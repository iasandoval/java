package com.nacho.utils;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.*;

public class ComparatorExample {

    @Test
    public void test1() {

        System.out.println("Test 01");

        // Current Date
        Date currentDate = this.getDate(7,1,2019);

        System.out.println("Current Date => " + currentDate);

        Date d1 = this.getDate(6,21,2018);
        Date d2 = this.getDate(7,21,2018);
        Date d3 = this.getDate(6,21,2018);

        DcCaseProgramIndvCargo c1 = new DcCaseProgramIndvCargo(110047283, 704021210, new Timestamp(d1.getTime()));
        DcCaseProgramIndvCargo c2 = new DcCaseProgramIndvCargo(110047283, 704021210, new Timestamp(d2.getTime()));
        DcCaseProgramIndvCargo c3 = new DcCaseProgramIndvCargo(110047283, 704021210, new Timestamp(d3.getTime()));

        DcCaseProgramIndvCargo[] cargos = {c1, c2, c3};

        Date max = this.getMaxQRFDueDate(cargos);

        System.out.println("Max QRF Due Date => " + max);

        Date newQRF = null;

        if(max != null) {
            newQRF = this.calculateQRFDueDate(max, currentDate);
        }


        System.out.println("New QRF Due Date => " + newQRF);

    }

    private Date getDate(int month, int day, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    private Date calculateQRFDueDate(Date qrfDueDate, Date currentDate) {
        if (qrfDueDate.after(currentDate)) {
            // Set the Max QRF Due date to all individuals
            return qrfDueDate;

        } else {
            // Add 3 months until qrfDueDate.after(currentDate)
            Date newQrfDueDate = this.addMonthsToDate(qrfDueDate, 3);
            System.out.println("QRF + 3 Months => " + newQrfDueDate);
            return this.calculateQRFDueDate(newQrfDueDate, currentDate);
        }
    }



    private Date getMaxQRFDueDate(DcCaseProgramIndvCargo[] dcCaseProgramIndvCargos) {
        // Comparator for the QRF Due date
        Comparator<DcCaseProgramIndvCargo> comp = new Comparator<DcCaseProgramIndvCargo>() {
            @Override
            public int compare(DcCaseProgramIndvCargo cargo1, DcCaseProgramIndvCargo cargo2) {
                if (cargo1.getQrfDueDt() == null && cargo2.getQrfDueDt() != null) {
                    return -1;
                } else if (cargo1.getQrfDueDt() == null && cargo2.getQrfDueDt() == null) {
                    return 0;
                } else if (cargo1.getQrfDueDt() != null && cargo2.getQrfDueDt() == null) {
                    return 1;
                } else {
                    return cargo1.getQrfDueDt().compareTo(cargo2.getQrfDueDt());
                }
            }
        };

        List<DcCaseProgramIndvCargo> listCasePrgInd = Arrays.asList(dcCaseProgramIndvCargos);

        return Collections.max(listCasePrgInd, comp).getQrfDueDt();
    }

    private Date addMonthsToDate(Date inDate1, int months) {
        Date returnDate = null;

        if (inDate1 != null) {
            Calendar c1 = Calendar.getInstance();
            c1.setTime(inDate1);
            c1.add(Calendar.MONTH, months);

            returnDate = c1.getTime();
        }

        return returnDate;
    }


    class DcCaseProgramIndvCargo {
        private final long caseNum;
        private final long indvId;
        private final Timestamp qrfDueDt;

        public DcCaseProgramIndvCargo(long caseNum, long indvId, Timestamp qrfDueDt) {
            this.caseNum = caseNum;
            this.indvId = indvId;
            this.qrfDueDt = qrfDueDt;
        }

        public long getCaseNum() {
            return caseNum;
        }

        public long getIndvId() {
            return indvId;
        }

        public Timestamp getQrfDueDt() {
            return qrfDueDt;
        }
    }
}
