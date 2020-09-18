package gov.state.nextgen.common.application;

import java.util.*;

import gov.state.nextgen.common.cargo.custom.T1001AppRqstCargo;
import gov.state.nextgen.common.cargo.custom.T1002AppDtlCargo;

/**
 * This class is the representation of the Application Rule Evaluator.
 * Class created as part of CR 495143 (WI 97791/97794).
 *
 * @author isandovalhiguera AKA Nacho
 *
 */
public class ApplicationRuleEvaluator implements RuleEvaluator {

    private static final String YES = "Y";
    private static final String NO = "N";
    private static final List<ApplicationRule> RULES;

    static {
        RULES = ApplicationRuleEvaluator.getRules();
    }

    private ApplicationRule state;
    private ApplicationRule match;
    private String category;

    public ApplicationRuleEvaluator(T1002AppDtlCargo c2) {
        T1001AppRqstCargo c1 = new T1001AppRqstCargo();

        this.state = this.convert(c1, c2);
    }

    public ApplicationRuleEvaluator(ApplicationRule r) {
        this.state = r;
    }

    public ApplicationRuleEvaluator withExpeditedFS(char expeditedFS) {
        this.state.setExFs(String.valueOf(expeditedFS));
        return this;
    }

    public ApplicationRuleEvaluator withPregnancy(String isPregnancy) {
        this.state.setPreg(isPregnancy);
        return this;
    }

    public RuleEvaluator evaluate() {
        this.match = this.evaluate(this.state);

        if (this.isMatch()) {
            this.category = this.match.getCode();
        }

        return this;
    }

    public boolean isMatch() {
        return this.match != null;
    }

    public String getCategory() {
        return this.category;
    }

    public ApplicationRule getMatch() {
        return this.match;
    }

    public ApplicationRule getState() {
        return this.state;
    }

    private boolean isYesNo(String value) {
        return YES.equals(value) || NO.equals(value);
    }

    private boolean isYesNo(char value) {
        return this.isYesNo(String.valueOf(value));
    }

    private static Integer objectToInteger(Object o) {
        return (o != null) ? Integer.valueOf(o.toString()) : 0;
    }

    private static List<ApplicationRule> getRules() {

        List<ApplicationRule> rules = new ArrayList<>();

        ApplicationRule EXFS = new ApplicationRule("EXFS", "Expedited SNAP Only Application", 1, "ES");
        EXFS.setExFs(YES);
        EXFS.setPreg(NO);
        EXFS.setQTrack(NO);
        EXFS.setTanf(NO);
        EXFS.setFs(YES);
        EXFS.setMa(NO);

        ApplicationRule EXFS_PREG = new ApplicationRule("EXFS_PREG", "Expedited SNAP with Pregnancy", 2, "ES");
        EXFS_PREG.setExFs(YES);
        EXFS_PREG.setPreg(YES);
        EXFS_PREG.setQTrack(NO);
        EXFS_PREG.setFs(YES);
        EXFS_PREG.setMa(YES);

        ApplicationRule EXFS_PREG_QTRACK = new ApplicationRule("EXFS_PREG_QTRACK", "Expedited SNAP with Pregnancy and Q-Track", 3, "ES");
        EXFS_PREG_QTRACK.setExFs(YES);
        EXFS_PREG_QTRACK.setPreg(YES);
        EXFS_PREG_QTRACK.setQTrack(YES);
        EXFS_PREG_QTRACK.setFs(YES);
        EXFS_PREG_QTRACK.setMa(YES);

        ApplicationRule EXFS_QTRACK = new ApplicationRule("EXFS_QTRACK", "Expedited FS with Q-TRACK and MA", 4, "ES");
        EXFS_QTRACK.setExFs(YES);
        EXFS_QTRACK.setPreg(NO);
        EXFS_QTRACK.setQTrack(YES);
        EXFS_QTRACK.setFs(YES);

        ApplicationRule EXFS_TANF = new ApplicationRule("EXFS_TANF", "Expedited FS with TANF", 5, "ES");
        EXFS_TANF.setExFs(YES);
        EXFS_TANF.setQTrack(NO);
        EXFS_TANF.setTanf(YES);
        EXFS_TANF.setFs(YES);

        ApplicationRule EXFS_MA = new ApplicationRule("EXFS_MA", "Expedited FS with MA", 6, "ES");
        EXFS_MA.setExFs(YES);
        EXFS_MA.setPreg(NO);
        EXFS_MA.setQTrack(NO);
        EXFS_MA.setTanf(NO);
        EXFS_MA.setFs(YES);
        EXFS_MA.setMa(YES);

        ApplicationRule PREG_TANF_FS_MA = new ApplicationRule("PREG_TANF_FS_MA", "Pregnancy with TANF, FS and MA", 7, "PR");
        PREG_TANF_FS_MA.setExFs(NO);
        PREG_TANF_FS_MA.setPreg(YES);
        PREG_TANF_FS_MA.setQTrack(NO);
        PREG_TANF_FS_MA.setTanf(YES);
        PREG_TANF_FS_MA.setFs(YES);
        PREG_TANF_FS_MA.setMa(YES);

        ApplicationRule PREG_TANF_MA = new ApplicationRule("PREG_TANF_MA", "Pregnancy with TANF and MA", 7, "PR");
        PREG_TANF_MA.setExFs(NO);
        PREG_TANF_MA.setPreg(YES);
        PREG_TANF_MA.setQTrack(NO);
        PREG_TANF_MA.setTanf(YES);
        PREG_TANF_MA.setFs(NO);
        PREG_TANF_MA.setMa(YES);

        ApplicationRule PREG_FS_MA = new ApplicationRule("PREG_FS_MA", "Pregnancy with FS and MA", 7, "PR");
        PREG_FS_MA.setExFs(NO);
        PREG_FS_MA.setPreg(YES);
        PREG_FS_MA.setQTrack(NO);
        PREG_FS_MA.setTanf(NO);
        PREG_FS_MA.setFs(YES);
        PREG_FS_MA.setMa(YES);

        ApplicationRule PREG_MA = new ApplicationRule("PREG_MA", "Pregnancy with MA", 7, "PR");
        PREG_MA.setExFs(NO);
        PREG_MA.setPreg(YES);
        PREG_MA.setQTrack(NO);
        PREG_MA.setTanf(NO);
        PREG_MA.setFs(NO);
        PREG_MA.setMa(YES);

        ApplicationRule PREG_QTRACK_TANF_FS_MA = new ApplicationRule("PREG_QTRACK_TANF_FS_MA", "Pregnancy + Q-Track with TANF, FS and MA", 8, "PR");
        PREG_QTRACK_TANF_FS_MA.setExFs(NO);
        PREG_QTRACK_TANF_FS_MA.setPreg(YES);
        PREG_QTRACK_TANF_FS_MA.setQTrack(YES);
        PREG_QTRACK_TANF_FS_MA.setTanf(YES);
        PREG_QTRACK_TANF_FS_MA.setFs(YES);
        PREG_QTRACK_TANF_FS_MA.setMa(YES);

        ApplicationRule PREG_QTRACK_TANF_MA = new ApplicationRule("PREG_QTRACK_TANF_MA", "Pregnancy + Q-Track with TANF and MA", 8, "PR");
        PREG_QTRACK_TANF_MA.setExFs(NO);
        PREG_QTRACK_TANF_MA.setPreg(YES);
        PREG_QTRACK_TANF_MA.setQTrack(YES);
        PREG_QTRACK_TANF_MA.setTanf(YES);
        PREG_QTRACK_TANF_MA.setFs(NO);
        PREG_QTRACK_TANF_MA.setMa(YES);

        ApplicationRule PREG_QTRACK_FS_MA = new ApplicationRule("PREG_QTRACK_FS_MA", "Pregnancy + Q-Track with FS and MA", 8, "PR");
        PREG_QTRACK_FS_MA.setExFs(NO);
        PREG_QTRACK_FS_MA.setPreg(YES);
        PREG_QTRACK_FS_MA.setQTrack(YES);
        PREG_QTRACK_FS_MA.setTanf(NO);
        PREG_QTRACK_FS_MA.setFs(YES);
        PREG_QTRACK_FS_MA.setMa(YES);

        ApplicationRule PREG_QTRACK_MA = new ApplicationRule("PREG_QTRACK_MA", "Pregnancy + Q-Track with MA", 8, "PR");
        PREG_QTRACK_MA.setExFs(NO);
        PREG_QTRACK_MA.setPreg(YES);
        PREG_QTRACK_MA.setQTrack(YES);
        PREG_QTRACK_MA.setTanf(NO);
        PREG_QTRACK_MA.setFs(NO);
        PREG_QTRACK_MA.setMa(YES);

        ApplicationRule QTRACK_TANF_FS_MA = new ApplicationRule("QTRACK_TANF_FS_MA", "Q-Track Application with TANF, FS and MA", 9, "QT");
        QTRACK_TANF_FS_MA.setExFs(NO);
        QTRACK_TANF_FS_MA.setPreg(NO);
        QTRACK_TANF_FS_MA.setQTrack(YES);
        QTRACK_TANF_FS_MA.setTanf(YES);
        QTRACK_TANF_FS_MA.setFs(YES);
        QTRACK_TANF_FS_MA.setMa(YES);

        ApplicationRule QTRACK_TANF_MA = new ApplicationRule("QTRACK_TANF_MA", "Q-Track Application with TANF and MA", 9, "QT");
        QTRACK_TANF_MA.setExFs(NO);
        QTRACK_TANF_MA.setPreg(NO);
        QTRACK_TANF_MA.setQTrack(YES);
        QTRACK_TANF_MA.setTanf(YES);
        QTRACK_TANF_MA.setFs(NO);
        QTRACK_TANF_MA.setMa(YES);

        ApplicationRule QTRACK_FS_MA = new ApplicationRule("QTRACK_FS_MA", "Q-Track Application with FS and MA", 9, "QT");
        QTRACK_FS_MA.setExFs(NO);
        QTRACK_FS_MA.setPreg(NO);
        QTRACK_FS_MA.setQTrack(YES);
        QTRACK_FS_MA.setTanf(NO);
        QTRACK_FS_MA.setFs(YES);
        QTRACK_FS_MA.setMa(YES);

        ApplicationRule QTRACK_MA = new ApplicationRule("QTRACK_MA", "Q-Track Application with MA", 9, "QT");
        QTRACK_MA.setExFs(NO);
        QTRACK_MA.setPreg(NO);
        QTRACK_MA.setQTrack(YES);
        QTRACK_MA.setTanf(NO);
        QTRACK_MA.setFs(NO);
        QTRACK_MA.setMa(YES);

        ApplicationRule TANF_FS_MA = new ApplicationRule("TANF_FS_MA", "TANF Combo Application with FS and MA", 10, "TF");
        TANF_FS_MA.setExFs(NO);
        TANF_FS_MA.setPreg(NO);
        TANF_FS_MA.setQTrack(NO);
        TANF_FS_MA.setTanf(YES);
        TANF_FS_MA.setFs(YES);
        TANF_FS_MA.setMa(YES);

        ApplicationRule TANF_MA = new ApplicationRule("TANF_MA", "TANF Combo Application with MA", 10, "TF");
        TANF_MA.setExFs(NO);
        TANF_MA.setPreg(NO);
        TANF_MA.setQTrack(NO);
        TANF_MA.setTanf(YES);
        TANF_MA.setFs(NO);
        TANF_MA.setMa(YES);

        ApplicationRule TANF_FS = new ApplicationRule("TANF_FS", "TANF Combo Application with FS", 10, "TF");
        TANF_FS.setExFs(NO);
        TANF_FS.setQTrack(NO);
        TANF_FS.setTanf(YES);
        TANF_FS.setFs(YES);
        TANF_FS.setMa(NO);

        ApplicationRule TANF = new ApplicationRule("TANF", "TANF Application (Non-Combo)", 10, "TF");
        TANF.setExFs(NO);
        TANF.setQTrack(NO);
        TANF.setTanf(YES);
        TANF.setFs(NO);
        TANF.setMa(NO);

        ApplicationRule FS_MA = new ApplicationRule("FS_MA", "FS Combo Application with MA", 11, "FS");
        FS_MA.setExFs(NO);
        FS_MA.setPreg(NO);
        FS_MA.setQTrack(NO);
        FS_MA.setTanf(NO);
        FS_MA.setFs(YES);
        FS_MA.setMa(YES);

        ApplicationRule FS = new ApplicationRule("FS", "FS Application (Non-Combo)", 11, "FS");
        FS.setExFs(NO);
        FS.setQTrack(NO);
        FS.setTanf(NO);
        FS.setFs(YES);
        FS.setMa(NO);

        ApplicationRule MA = new ApplicationRule("MA", "MA Application (Non-Combo)", 12, "MA");
        MA.setExFs(NO);
        MA.setPreg(NO);
        MA.setQTrack(NO);
        MA.setTanf(NO);
        MA.setFs(NO);
        MA.setMa(YES);

        ApplicationRule WIC_PREG = new ApplicationRule("WIC_PREG", "WIC Application with Pregnancy", 13, "WC");
        WIC_PREG.setPreg(YES);
        WIC_PREG.setWic(YES);

        ApplicationRule WIC = new ApplicationRule("WIC", "WIC Application (Non-Combo)", 14, "WC");
        WIC.setPreg(NO);
        WIC.setWic(YES);

        ApplicationRule CC = new ApplicationRule("CC", "CAPS Application (Non-Combo)", 15, "CC");
        CC.setCc(YES);

        ApplicationRule LIHEAP = new ApplicationRule("LIHEAP", "LIHEAP (Non-Combo)", 16, "LI");
        LIHEAP.setLiheap(YES);

        rules.add(EXFS);
        rules.add(EXFS_PREG);
        rules.add(EXFS_PREG_QTRACK);
        rules.add(EXFS_QTRACK);
        rules.add(EXFS_TANF);
        rules.add(EXFS_MA);
        rules.add(PREG_TANF_FS_MA);
        rules.add(PREG_TANF_MA);
        rules.add(PREG_FS_MA);
        rules.add(PREG_MA);
        rules.add(PREG_QTRACK_TANF_FS_MA);
        rules.add(PREG_QTRACK_TANF_MA);
        rules.add(PREG_QTRACK_FS_MA);
        rules.add(PREG_QTRACK_MA);
        rules.add(QTRACK_TANF_FS_MA);
        rules.add(QTRACK_TANF_MA);
        rules.add(QTRACK_FS_MA);
        rules.add(QTRACK_MA);
        rules.add(TANF_FS_MA);
        rules.add(TANF_MA);
        rules.add(TANF_FS);
        rules.add(TANF);
        rules.add(FS_MA);
        rules.add(FS);
        rules.add(MA);
        rules.add(WIC_PREG);
        rules.add(WIC);
        rules.add(CC);
        rules.add(LIHEAP);


        return rules;

    }

    private ApplicationRule evaluate(ApplicationRule app) { // NOSONAR

        ApplicationRule rule = null;

        for (ApplicationRule r : RULES) {

            boolean found = true;

            if (r.getExFs() != null) {
                found &= r.getExFs().equals(app.getExFs());
            }

            if (r.getPreg() != null) {
                found &= r.getPreg().equals(app.getPreg());
            }

            if (r.getQTrack() != null) {
                found &= r.getQTrack().equals(app.getQTrack());
            }

            if (r.getTanf() != null) {
                found &= r.getTanf().equals(app.getTanf());
            }

            if (r.getFs() != null) {
                found &= r.getFs().equals(app.getFs());
            }
            if (r.getMa() != null) {
                found &= r.getMa().equals(app.getMa());
            }
            if (r.getWic() != null) {
                found &= r.getWic().equals(app.getWic());
            }
            if (r.getCc() != null) {
                found &= r.getCc().equals(app.getCc());
            }
            if (r.getLiheap() != null) {
                found &= r.getLiheap().equals(app.getLiheap());
            }

            if (found) {
                rule = r;
                break;
            }

        }

        return rule;
    }

    private ApplicationRule convert(T1001AppRqstCargo c1, T1002AppDtlCargo c2) {

        ApplicationRule rule = new ApplicationRule();

        if (isYesNo(c1.getExpeditedFapSw())) {
            rule.setExFs(String.valueOf(c1.getExpeditedFapSw()));
        }

        // If Pregnancy is null, consider it as NO
        if (!YES.equals(c2.getPregInd()) || c2.getPregInd() == null) {
            c2.setPregInd(NO);
        }

        if (isYesNo(c2.getPregInd())) {
            rule.setPreg(c2.getPregInd());
        }

        // If Q-track is null, consider it as NO
        if (!YES.equals(c2.getQTrack()) || c2.getQTrack() == null) {
            c2.setQTrack(NO);
        }

        if (isYesNo(c2.getQTrack())) {
            rule.setQTrack(c2.getQTrack());
        }

        if (isYesNo(c2.getTanfRqstSw())) {
            rule.setTanf(String.valueOf(c2.getTanfRqstSw()));
        }

        if (isYesNo(c2.getFsRqstSw())) {
            rule.setFs(String.valueOf(c2.getFsRqstSw()));
        }

        if (isYesNo(c2.getMaRqstSw())) {
            rule.setMa(String.valueOf(c2.getMaRqstSw()));
        }

        if (isYesNo(c2.getWicRqstInd())) {
            rule.setWic(c2.getWicRqstInd());
        }

        if (isYesNo(c2.getCcRqstSw())) {
            rule.setCc(String.valueOf(c2.getCcRqstSw()));
        }

        if (isYesNo(c2.getLiheapRqstInd())) {
            rule.setLiheap(c2.getLiheapRqstInd());
        }

        return rule;

    }

}
