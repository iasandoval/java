package gov.state.nextgen.common.cargo.custom;

import java.sql.Timestamp;

public class T1001AppRqstCargo {
    private String appNum;
    private String appTyp;
    private char appStatCd;
    private java.sql.Timestamp appRcvDt;
    private char expeditedFapSw;

    public T1001AppRqstCargo() {

    }

    public T1001AppRqstCargo(String appNum, char expeditedFapSw) {
        this.appNum = appNum;
        this.expeditedFapSw = expeditedFapSw;
    }

    public String getAppNum() {
        return appNum;
    }

    public void setAppNum(String appNum) {
        this.appNum = appNum;
    }

    public String getAppTyp() {
        return appTyp;
    }

    public void setAppTyp(String appTyp) {
        this.appTyp = appTyp;
    }

    public char getAppStatCd() {
        return appStatCd;
    }

    public void setAppStatCd(char appStatCd) {
        this.appStatCd = appStatCd;
    }

    public Timestamp getAppRcvDt() {
        return appRcvDt;
    }

    public void setAppRcvDt(Timestamp appRcvDt) {
        this.appRcvDt = appRcvDt;
    }

    public char getExpeditedFapSw() {
        return expeditedFapSw;
    }

    public void setExpeditedFapSw(char expeditedFapSw) {
        this.expeditedFapSw = expeditedFapSw;
    }
}
