package com.lordjoe.ssh;

/**
 * com.lordjoe.ssh.BLASTProgram
 * User: Steve
 * Date: 1/25/20
 */
public enum BLASTProgram {

    BLASTN, BLASTP,BLASTX, RPBLAST, RPSTBLAST, PSIBLAST, TBLASTN;

    public static BLASTProgram fromString(String s) {
        s = s.toUpperCase();
        return BLASTProgram.valueOf(s);
    }

    public static String  prefix(BLASTProgram program) {
        switch (program) {
            case BLASTN:
                return "bn_";
              case BLASTP:
                  return "bp_";
            case BLASTX:
                return "bx_";
            case TBLASTN:
                return "tbn_";
            default:
                return "xxxx_";
        }
    }

    public static String[] relevantProperties(BLASTProgram program) {
        switch (program) {
            case BLASTN:
                return new String[]{
                        "bn_num_alignments",
                        "bn_evalue",
                        "bn_word_size",
                        "bn_match_scores",
                        "bn_gapcosts",
                        "bn_filter1",
                        "bn_filter2",

                };
            case BLASTP:
                return new String[]{
                        "bp_num_alignments",
                        "bp_evalue",
                        "bp_word_size",
                        "bp_matrix",
              //          "bp_gapcosts",
                        "bp_filter1",
                        "bp_filter2",

                };
            case BLASTX:
                return new String[]{
                        "bx_num_alignments",
                        "bx_evalue",
                        "bx_word_size",
                        "bx_matrix",
                        "bx_gapcosts",
                        "bx_filter1",
                        "bx_filter2",

                };
            case TBLASTN:
                return new String[]{
                        "tbn_num_alignments",
                        "tbn_evalue",
                        "tbn_word_size",
                        "tbn_matrix",
                        "tbn_gapcosts",
                        "tbn_filter1",
                        "tbn_filter2",

                };
            default:
                return new String[] {};
        }
    }
}
