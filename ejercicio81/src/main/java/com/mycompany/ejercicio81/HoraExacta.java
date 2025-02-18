package com.mycompany.ejercicio81;

public class HoraExacta extends Hora{
    private int segundo;
    
    HoraExacta(int hora,int minuto, int segundo){
        super(hora,minuto);
        setSegundo(segundo);
    }
    
    HoraExacta(){
        super();
        setSegundo(0);
    }

    public void setSegundo(int segundo) {
        if(segundo>=0 && segundo<60){
            this.segundo = segundo;
        }
        else{
            this.segundo=0;
            System.out.println("Valor no válido. Por defecto establecido '0'");
        }
    }

    public int getSegundo() {
        return segundo;
    }
        
    void inc(){
        if(segundo==59){
            segundo=0;
            super.inc();
        }
        else{
            segundo+=1;
        }
    }

    @Override
    public String toString() {
        String hora=super.toString();
        return hora+" HoraExacta{" + "segundo=" + segundo + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if(!super.equals(obj)){
            return false;
        }
        final HoraExacta other = (HoraExacta) obj;
        return this.segundo == other.segundo;
    }
    
}
