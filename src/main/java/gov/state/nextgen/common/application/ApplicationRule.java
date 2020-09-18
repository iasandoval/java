package gov.state.nextgen.common.application;

import java.util.Objects;

/**
 * This class is the representation of the Application Rule.
 * Class created as part of CR 495143 (WI 97791/97794).
 *
 * @author isandovalhiguera AKA Nacho
 *
 */
public class ApplicationRule {

    abstract class ColumnName { //NOSONAR
        public static final String CODE = "CODE";
        public static final String DESCRIPTION = "DESCRIPTION";
        public static final String GROUPRANK = "GROUPRANK";
        public static final String CATGROUP = "CATGROUP";
        public static final String SUBGROUP = "SUBGROUP";
        public static final String EXFS = "EXFS";
        public static final String PREGNANCY = "PREGNANCY";
        public static final String QTRACK = "QTRACK";
        public static final String TANF = "TANF";
        public static final String FS = "FS";
        public static final String MA = "MA";
        public static final String WIC = "WIC";
        public static final String CC = "CC";
        public static final String LIHEAP = "LIHEAP";
    }

    private String code;
    private String description;
    private long rank;
    private String catGroup;
    private String subGroup;
    private String exFs;
    private String preg;
    private String qTrack;
    private String tanf;
    private String fs;
    private String ma;
    private String wic;
    private String cc;
    private String liheap;

    public ApplicationRule() {
        // Empty constructor
    }

    public ApplicationRule(String code, String description, long rank, String catGroup) {
        this.code = code;
        this.description = description;
        this.rank = rank;
        this.catGroup = catGroup;
    }

    public ApplicationRule(String exFs, String preg, String qTrack, String tanf, String fs, String ma, String wic,
                           String cc, String liheap) {
        this.exFs = exFs;
        this.preg = preg;
        this.qTrack = qTrack;
        this.tanf = tanf;
        this.fs = fs;
        this.ma = ma;
        this.wic = wic;
        this.cc = cc;
        this.liheap = liheap;
    }

    public String getCatGroup() {
        return catGroup;
    }

    public void setCatGroup(String catGroup) {
        this.catGroup = catGroup;
    }

    public String getSubGroup() {
        return subGroup;
    }

    public void setSubGroup(String subGroup) {
        this.subGroup = subGroup;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public String getExFs() {
        return exFs;
    }

    public void setExFs(String exFs) {
        this.exFs = exFs;
    }

    public String getPreg() {
        return preg;
    }

    public void setPreg(String preg) {
        this.preg = preg;
    }

    public String getQTrack() {
        return qTrack;
    }

    public void setQTrack(String qTrack) {
        this.qTrack = qTrack;
    }

    public String getTanf() {
        return tanf;
    }

    public void setTanf(String tanf) {
        this.tanf = tanf;
    }

    public String getFs() {
        return fs;
    }

    public void setFs(String fs) {
        this.fs = fs;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getWic() {
        return wic;
    }

    public void setWic(String wic) {
        this.wic = wic;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getLiheap() {
        return liheap;
    }

    public void setLiheap(String liheap) {
        this.liheap = liheap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationRule that = (ApplicationRule) o;

        return
                Objects.equals(exFs, that.exFs) &&
                        Objects.equals(preg, that.preg) &&
                        Objects.equals(qTrack, that.qTrack) &&
                        Objects.equals(tanf, that.tanf) &&
                        Objects.equals(fs, that.fs) &&
                        Objects.equals(ma, that.ma) &&
                        Objects.equals(wic, that.wic) &&
                        Objects.equals(cc, that.cc) &&
                        Objects.equals(liheap, that.liheap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exFs, preg, qTrack, tanf, fs, ma, wic, cc, liheap);
    }

    @Override
    public String toString() {
        return "ApplicationRule{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", rank=" + rank +
                ", catGroup='" + catGroup + '\'' +
                ", subGroup='" + subGroup + '\'' +
                ", exFs='" + exFs + '\'' +
                ", preg='" + preg + '\'' +
                ", qTrack='" + qTrack + '\'' +
                ", tanf='" + tanf + '\'' +
                ", fs='" + fs + '\'' +
                ", ma='" + ma + '\'' +
                ", wic='" + wic + '\'' +
                ", cc='" + cc + '\'' +
                ", liheap='" + liheap + '\'' +
                '}';
    }

}
