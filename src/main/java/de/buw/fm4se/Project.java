package de.buw.fm4se;

import edu.mit.csail.sdg.alloy4.*;
import edu.mit.csail.sdg.ast.Expr;
import edu.mit.csail.sdg.ast.Func;
import edu.mit.csail.sdg.ast.Module;
import edu.mit.csail.sdg.ast.Sig;
import edu.mit.csail.sdg.parser.CompUtil;

public class Project {

    public static void main(String[] args) throws Err {

        A4Reporter rep = new A4Reporter() {

            // For example, here we choose to display each "warning" by printing
            // it to System.out
            @Override
            public void warning(ErrorWarning msg) {
                System.out.print("Relevance Warning:\n" + (msg.toString().trim()) + "\n\n");
                System.out.flush();
            }
        };

        String fileName = "src/main/resources/dreadburyproject.als";
        Module world = CompUtil.parseEverything_fromFile(rep, null, fileName);

        System.out.println(":: facts");
        SafeList<Pair<String, Expr>> facts = world.getAllFacts();
        for (Pair<String, Expr> f : facts) {
            System.out.println(f.a);
            System.out.println(f.b);
        }

        System.out.println(":: funcs");
        SafeList<Func> funcs = world.getAllFunc();
        for (Func f : funcs) {
            System.out.println(f.label);
            System.out.println(f.isPred);
        }


        System.out.println(":: sigs");
        SafeList<Sig> sigs = world.getAllSigs();
        for (Sig s : sigs) {
            System.out.println(s.label);
            System.out.println(s.builtin);
        }

    }

}
