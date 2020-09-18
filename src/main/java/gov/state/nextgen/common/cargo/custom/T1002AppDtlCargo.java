package gov.state.nextgen.common.cargo.custom;

public class T1002AppDtlCargo {
    private String appNum;
    private String pregInd;
    private String QTrack;
    private char tanfRqstSw;
    private char fsRqstSw;
    private char maRqstSw;
    private String wicRqstInd;
    private char ccRqstSw;
    private String liheapRqstInd;

    public T1002AppDtlCargo(String appNum, String pregInd, String QTrack, char tanfRqstSw, char fsRqstSw, char maRqstSw, String wicRqstInd, char ccRqstSw, String liheapRqstInd) {
        this.appNum = appNum;
        this.pregInd = pregInd;
        this.QTrack = QTrack;
        this.tanfRqstSw = tanfRqstSw;
        this.fsRqstSw = fsRqstSw;
        this.maRqstSw = maRqstSw;
        this.wicRqstInd = wicRqstInd;
        this.ccRqstSw = ccRqstSw;
        this.liheapRqstInd = liheapRqstInd;
    }

    public String getAppNum() {
        return appNum;
    }

    public void setAppNum(String appNum) {
        this.appNum = appNum;
    }

    public String getPregInd() {
        return pregInd;
    }

    public void setPregInd(String pregInd) {
        this.pregInd = pregInd;
    }

    public String getQTrack() {
        return QTrack;
    }

    public void setQTrack(String QTrack) {
        this.QTrack = QTrack;
    }

    public char getTanfRqstSw() {
        return tanfRqstSw;
    }

    public void setTanfRqstSw(char tanfRqstSw) {
        this.tanfRqstSw = tanfRqstSw;
    }

    public char getFsRqstSw() {
        return fsRqstSw;
    }

    public void setFsRqstSw(char fsRqstSw) {
        this.fsRqstSw = fsRqstSw;
    }

    public char getMaRqstSw() {
        return maRqstSw;
    }

    public void setMaRqstSw(char maRqstSw) {
        this.maRqstSw = maRqstSw;
    }

    public String getWicRqstInd() {
        return wicRqstInd;
    }

    public void setWicRqstInd(String wicRqstInd) {
        this.wicRqstInd = wicRqstInd;
    }

    public char getCcRqstSw() {
        return ccRqstSw;
    }

    public void setCcRqstSw(char ccRqstSw) {
        this.ccRqstSw = ccRqstSw;
    }

    public String getLiheapRqstInd() {
        return liheapRqstInd;
    }

    public void setLiheapRqstInd(String liheapRqstInd) {
        this.liheapRqstInd = liheapRqstInd;
    }
}
