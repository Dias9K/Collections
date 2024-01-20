package CursoAntigo.ExercíciosPropostos;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExercicioProposto01 {
    /*
     * Crie um conjunto contendo as cores do arco-íris e:
     * 
     * Exiba todas as cores uma abaixo da outra
     * 
     * A quantidade de cores que o arco-íris tem
     * 
     * Exiba as cores em ordem alfabética
     * 
     * Exiba as cores na ordem inversa da que foi informada
     * 
     * Exiba todas as cores que começam com a letra ”v”
     * 
     * Remova todas as cores que não começam com a letra “a”
     * 
     * Limpe o conjunto
     * 
     * Confira se o conjunto está vazio
     */
    public static void main(String[] args) {
        Set<Cores> coresSet = new TreeSet<>() {
            {
                add(new Cores("vermelho"));
                add(new Cores("laranja"));
                add(new Cores("amarelo"));
                add(new Cores("verde"));
                add(new Cores("azul"));
                add(new Cores("anil"));
                add(new Cores("roxo"));

            }
        };
        System.out.println("\nExibindo cores uma abaixo da outra e em ordem alfabética: ");
        for (Cores cores : coresSet) {
            System.out.println(cores);
        }

        System.out.println("\nQuantidade de cores: " + coresSet.size());

        System.out.println("\nCores inversas: ");
        Set<Cores> coresInversas = new TreeSet<>(new ComparatorCoresInversas());
        coresInversas.addAll(coresSet);
        for (Cores cores : coresInversas) {
            System.out.println(cores);
        }

        System.out.println("\nTodas as cores que começam com a letra \"V\":\n");
        Set<Cores> coresComV = new TreeSet<>();
        coresComV.addAll(coresSet);

        Iterator<Cores> iteratorV = coresComV.iterator();
        while (iteratorV.hasNext()) {
            Cores coresV = iteratorV.next(); // NÃO pode criar um atributo usando outro tipo além do tipo estabelecido
                                             // no
                                             // iterator
            if (coresV.getCor().startsWith("v"))
                System.out.println(coresV);

        }

        System.out.println("\nRemovendo as cores que NÃO começam com \"A\" e mostrando os elementos restantes:\n");
        Set<Cores> coresSemV = new TreeSet<>();
        coresSemV.addAll(coresSet);

        Iterator<Cores> iteratorSemV = coresSemV.iterator();
        while (iteratorSemV.hasNext()) {
            Cores corSemV = iteratorSemV.next();
            if (!corSemV.getCor().startsWith("a"))
                iteratorSemV.remove();
        }
        for (Cores cores : coresSemV) {
            System.out.println(cores);

        }
        System.out.println("\nLimpando o conjunto...\n");
        coresSet.removeAll(coresSet);

        // TODO conferir se o conjunto está vazio
        if (coresSet.isEmpty() == true)
        System.out.println("\nO conjunto está vazio? Sim");
    }
}

class Cores implements Comparable<Cores> {

    private String cor;

    public Cores(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "cor = " + cor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cor == null) ? 0 : cor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cores other = (Cores) obj;
        if (cor == null) {
            if (other.cor != null)
                return false;
        } else if (!cor.equals(other.cor))
            return false;
        return true;
    }

    @Override
    public int compareTo(Cores o) {
        return this.getCor().compareTo(o.getCor());
    }
}

class ComparatorCoresInversas implements Comparator<Cores> {

    @Override
    public int compare(Cores o1, Cores o2) {
        return -1;
    }

}
