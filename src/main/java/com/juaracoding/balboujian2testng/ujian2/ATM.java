package com.juaracoding.balboujian2testng.ujian2;

public class ATM {
    private double saldo;

    public ATM(double saldoAwal) {
        this.saldo = saldoAwal;
    }

    public double lihatSaldo() {
        return saldo;
    }

    public void setorUang(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
        } else {
            throw new IllegalArgumentException("Jumlah harus lebih besar dari 0");
        }
    }

    public void tarikUang(double jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah harus lebih besar dari 0");
        }
        if (jumlah > saldo) {
            throw new IllegalArgumentException("Saldo tidak mencukupi");
        }
        saldo -= jumlah;
    }
}