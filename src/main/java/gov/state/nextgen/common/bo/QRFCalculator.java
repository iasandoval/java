package gov.state.nextgen.common.bo;

import org.junit.Test;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class QRFCalculator {

    private static final int QRF_DUE_DATE_SPAN = 3;

    @Test
    public void testCalculateQRFDueDate_112078836() {

        Timestamp currentMaxQRFDueDate = this.setDate(2018, 4, 21);
        Timestamp qrfFormReceivedDt = this.setDate(2020, 3, 1);
        String qrfIncompleteRsn = null;

        Timestamp minOfMaxCertBegDt = this.setDate(2020, 4,1);

        Timestamp newQrfDueDt = this.calculateQRFDueDate(minOfMaxCertBegDt, currentMaxQRFDueDate, qrfFormReceivedDt, qrfIncompleteRsn);

        System.out.println(String.format("Case %s %s QRF Due date = %s", 112078836, "THIRD", newQrfDueDt));
    }

    @Test
    public void testCalculateQRFDueDate_111639537() {

        Timestamp currentMaxQRFDueDate = this.setDate(2020, 4, 21);
        Timestamp qrfFormReceivedDt = null; //this.setDate(2020, 3, 1);
        String qrfIncompleteRsn = null;

        Timestamp minOfMaxCertBegDt = this.setDate(2019, 7,1);

        Timestamp newQrfDueDt = this.calculateQRFDueDate(minOfMaxCertBegDt, currentMaxQRFDueDate, qrfFormReceivedDt, qrfIncompleteRsn);

        System.out.println(String.format("Case %s %s QRF Due date = %s", 111639537,"MAX", newQrfDueDt));
    }

    @Test
    public void testCalculateQRFDueDate_111677366() {

        Timestamp currentMaxQRFDueDate = this.setDate(2020, 3, 21);
        Timestamp qrfFormReceivedDt = this.setDate(2020, 5, 21);
        String qrfIncompleteRsn = null;

        //Timestamp minOfMaxCertBegDt = this.setDate(2019, 6,1);
        Timestamp minOfMaxCertBegDt = this.setDate(2019, 10,1);

        Timestamp newQrfDueDt = this.calculateQRFDueDate(minOfMaxCertBegDt, currentMaxQRFDueDate, qrfFormReceivedDt, qrfIncompleteRsn);

        System.out.println(String.format("Case %s %s QRF Due date = %s", 111677366, "THIRD", newQrfDueDt));
    }

    @Test
    public void testCalculateQRFDueDate_110816444() {

        Timestamp currentMaxQRFDueDate = this.setDate(2020, 11, 21);
        Timestamp qrfFormReceivedDt = null; //this.setDate(2020, 5, 21);
        String qrfIncompleteRsn = null;

        Timestamp minOfMaxCertBegDt = this.setDate(2019, 12,1);

        Timestamp newQrfDueDt = this.calculateQRFDueDate(minOfMaxCertBegDt, currentMaxQRFDueDate, qrfFormReceivedDt, qrfIncompleteRsn);

        System.out.println(String.format("Case %s %s QRF Due date = %s", 110816444, "MAX", newQrfDueDt));
    }

    /**
     * The method calculates new QRF due date.
     * First QRF Due date = min of max(cert_beg_dt) + 3 months
     * Second and Thrid = current newQrfDueDt ++ 3 months until new QRF due date is in the future (but less than certBegDtPlus12Months)
     *
     * @param minOfMaxCertBegDt
     * @param currentMaxQRFDueDate
     * @param qrfFormReceivedDt
     * @param qrfIncompleteRsn
     * @return
     */
    private Timestamp calculateQRFDueDate(Timestamp minOfMaxCertBegDt, Timestamp currentMaxQRFDueDate,
                                          Timestamp qrfFormReceivedDt, String qrfIncompleteRsn) {
        Timestamp certBegDtPlus12Months = null;
        Timestamp newQrfDueDt = null;
        Timestamp currentDate = toTimestamp(new Date()); //FwCalendar.getInstance().getDate().getTimestamp();

        //FIRST QRF Due date = min of max(cert_beg_dt) + 3 months
        newQrfDueDt = this.addMonthsToTimestamp(minOfMaxCertBegDt, QRF_DUE_DATE_SPAN);
        newQrfDueDt = this.setDayToTimestamp(newQrfDueDt, 21); //Day should be 21 of the month by the BRS

        certBegDtPlus12Months = this.addMonthsToTimestamp(minOfMaxCertBegDt, 12);

        if(qrfIncompleteRsn==null && qrfFormReceivedDt!=null) {
            if ((currentDate.before(newQrfDueDt) || currentDate.equals(newQrfDueDt))
                    && (this.addMonthsToTimestamp(newQrfDueDt, QRF_DUE_DATE_SPAN)).before(certBegDtPlus12Months)) {
                // SECOND QRF Due date =
                // If current date is on or before the First QRF Due date and Form Received date is provided,
                // extending the First QRF Due date by 3 months (but less than certBegDtPlus12Months)
                newQrfDueDt = (this.addMonthsToTimestamp(newQrfDueDt, QRF_DUE_DATE_SPAN));
            } else if (currentDate.after(newQrfDueDt)
                    && (this.addMonthsToTimestamp(newQrfDueDt, (QRF_DUE_DATE_SPAN + QRF_DUE_DATE_SPAN))).before(certBegDtPlus12Months)) {
                // THIRD QRF Due date =
                // If current date after the First QRF Due date and Form Received date is provided,
                // extending the First QRF Due date by 6 months (but less than certBegDtPlus12Months)
                newQrfDueDt = (this.addMonthsToTimestamp(newQrfDueDt, (QRF_DUE_DATE_SPAN + QRF_DUE_DATE_SPAN)));
            }
        }
        if(currentMaxQRFDueDate!=null && currentMaxQRFDueDate.after(newQrfDueDt) && currentMaxQRFDueDate.before(certBegDtPlus12Months)) {
            //if current maxQRFDueDate is greater than the calculated newQrfDueDt (but less than certBegDtPlus12Months),
            //use maxQRFDueDate as newQrfDueDt
            newQrfDueDt = currentMaxQRFDueDate;
        }
        return newQrfDueDt;
    }

    private Timestamp setDate(int year, int month, int day) {
        LocalDate localDate = LocalDate.of(year, month, day);
        return Timestamp.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    private Timestamp addMonthsToTimestamp(Timestamp tsTimestamp1, int iNoOfMonths) {

        Calendar calendar = new GregorianCalendar();

        calendar.setTime(tsTimestamp1);
        calendar.add(Calendar.MONTH, iNoOfMonths);

        return (new Timestamp(calendar.getTimeInMillis()));
    }

    private  Timestamp setDayToTimestamp(Timestamp ts, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(ts);
        cal.set(Calendar.DAY_OF_MONTH, day);
        return toTimestamp(cal.getTime());
    }

    private Timestamp toTimestamp(Date inDate) {
        return new Timestamp(inDate.getTime());
    }
}
