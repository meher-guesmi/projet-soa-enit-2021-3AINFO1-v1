package enit.bank.Algo;

import enit.bank.Domain.*;

import java.util.*;

public class Algorithme {

    public List<Recommendation> algo(List<String> listId, List<Recommendation> table) {

        List<Recommendation> comb=Combinations(listId);
        for(int i = 0; i < comb.size(); i++){
            var index=search(comb.get(i), table);
           if(index!= -1){// if comb  exist in table
             Recommendation rec=table.get(index);
             rec.setNbrOccurrences(comb.get(i).getNbrOccurrences());
             table.set(index, rec);
           } else{ // if comb doesn't exist in table
               table.add(comb.get(i));
           }
        }
        return table;
    }

    public List<Recommendation> Combinations(List<String> listId) {
        List<Recommendation> comb = new ArrayList<>();
        for (int i = 0; i <listId.size(); i++) {
            for (int j = i + 1; j <listId.size(); j++) {

                Recommendation rec = new Recommendation(listId.get(i), listId.get(j));

                comb.add(rec);
            }
        }
        return comb;
    }

    public int search(Recommendation rec,List<Recommendation> table) {

        for (int i = 0; i < table.size() - 1; i++) {
            if (rec.compareTo( table.get(i)))
                return i;
        }
        return -1;
    }
}
