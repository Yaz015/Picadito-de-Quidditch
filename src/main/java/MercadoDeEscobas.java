

import java.util.Calendar;

public class MercadoDeEscobas {
        private Integer numeroAleatorio=100;
        private int longitud=100;
        private Integer anioDeCreacion=2019;
        // private List<Integer> list= new ArrayList<>(longitud);

        public Integer getNumeroAleatorio(){
            return this.numeroAleatorio;
        }

        // public int getRandomElement(List<Integer> list)
        {
            //  Random rand = new Random();
            //   return list.get(rand.nextInt(list.size()));
        }
        //Los intervalos de números (rangos) son colecciones que pueden crearse como:
        // List<Integer> rango = IntStream.range(1, numeroAleatorio).boxed().collect(Collectors.toList());


        // public void actualizarMercado() {
        // this.numeroAleatorio=getRandomElement(this.list);
        //
        public Integer anioActual(){
            return Calendar.getInstance().get(Calendar.YEAR);

        }

        public Integer difDeAnios(){
            return anioActual()-anioDeCreacion;
        }

        public Integer actualizarMercadoDeEscobas(){
            return numeroAleatorio+difDeAnios();
        }

        public boolean debeActualizarMercadodeEscobas(){
            return difDeAnios()>0;
        }

        public Integer numeroArbitrario(){
            return getNumeroAleatorio()+difDeAnios();
        }
}


