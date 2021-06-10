package com.company;

interface Zaryadka1{
    public void V();
}

interface Zaryadka2{
    public void V();
}

class Phone1 implements Zaryadka1 {
    final public int volt = 220;

@Override
public void V() {
        System.out.println("220 Volt");
    }
}

class Phone2 implements Zaryadka2{
    final public int volt = 380;

@Override
public void V(){
        System.out.println("380 volt");
    }
}

class Adapter implements Zaryadka1{
    Zaryadka2 zaryadka2;

public Adapter(Zaryadka2 zaryadka2){
        this.zaryadka2 = zaryadka2;
    }

@Override
public void V(){
        zaryadka2.V();
    }
}

class Port{
    private Zaryadka1 Pt;
    public Port(Zaryadka1 Pt){
        this.Pt = Pt;
    }

public void work(){
        Pt.V();
    }
}

public class Main {
    public static void main(String[] args) {
        Zaryadka1 phone1 = new Phone1();
        Port Pn = new Port(phone1);
        Pn.work();

        Adapter phone2 = new Adapter(new Phone2());
        Port Pn2 = new Port(phone2);
        Pn2.work();
    }
}