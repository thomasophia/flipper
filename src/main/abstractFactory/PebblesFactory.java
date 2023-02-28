package main.abstractFactory;

public class PebblesFactory implements FontFactory {

    @Override
    public void produziertStart() {
        System.out.println(
                "  OooOOo.                                                                                                                  \n" +
                        "  O     `O                                                                                                                 \n" +
                        "  o      O                                             O                      O                     O                  O   \n" +
                        "  O     .o                                            oOo                    oOo                   oOo                oOo  \n" +
                        "  oOooOO'  `OoOo. .oOo. .oOo  .oOo       .oOo. 'OoOo.  o   .oOo. `OoOo.       o   .oOo.      .oOo   o   .oOoO' `OoOo.  o   \n" +
                        "  o         o     OooO' `Ooo. `Ooo.      OooO'  o   O  O   OooO'  o           O   O   o      `Ooo.  O   O   o   o      O   \n" +
                        "  O         O     O         O     O      O      O   o  o   O      O           o   o   O          O  o   o   O   O      o   \n" +
                        "  o'        o     `OoO' `OoO' `OoO'      `OoO'  o   O  `oO `OoO'  o           `oO `OoO'      `OoO'  `oO `OoO'o  o      `oO ");
    }

    @Override
    public void produziertEnde() {
        System.out.println(
                "   .oOOOo.                                                       \n" +
                        "  .O     o                                                       \n" +
                        "  o                                                              \n" +
                        "  O                                                              \n" +
                        "  O   .oOOo .oOoO' `oOOoOO. .oOo.      .oOo. `o   O .oOo. `OoOo. \n" +
                        "  o.      O O   o   O  o  o OooO'      O   o  O   o OooO'  o     \n" +
                        "   O.    oO o   O   o  O  O O          o   O  o  O  O      O     \n" +
                        "    `OooO'  `OoO'o  O  o  o `OoO'      `OoO'  `o'   `OoO'  o     ");
    }

    @Override
    public void produziertBall(int i) {
        switch (i) {
            case 1 -> System.out.println(
                    "\n" +
                            "o.oOOOo.          o  o             \n" +
                            " o     o         O  O         oO   \n" +
                            " O     O         o  o          O   \n" +
                            " oOooOO.         O  O          o   \n" +
                            " o     `O .oOoO' o  o          O   \n" +
                            " O      o O   o  O  O          o   \n" +
                            " o     .O o   O  o  o          O   \n" +
                            " `OooOO'  `OoO'o Oo Oo       OooOO \n"

            );
            case 2 -> System.out.println(
                    "\n" +
                            "o.oOOOo.          o  o              \n" +
                            " o     o         O  O        .oOOo. \n" +
                            " O     O         o  o             O \n" +
                            " oOooOO.         O  O             o \n" +
                            " o     `O .oOoO' o  o            O' \n" +
                            " O      o O   o  O  O           O   \n" +
                            " o     .O o   O  o  o         .O    \n" +
                            " `OooOO'  `OoO'o Oo Oo       oOoOoO \n"
            );
            case 3 -> System.out.println(
                    "\n" +
                            "o.oOOOo.          o  o              \n" +
                            " o     o         O  O        .oOOo. \n" +
                            " O     O         o  o             O \n" +
                            " oOooOO.         O  O             o \n" +
                            " o     `O .oOoO' o  o          .oO  \n" +
                            " O      o O   o  O  O             o \n" +
                            " o     .O o   O  o  o             O \n" +
                            " `OooOO'  `OoO'o Oo Oo       `OooO' \n"
            );
        }
    }
}
