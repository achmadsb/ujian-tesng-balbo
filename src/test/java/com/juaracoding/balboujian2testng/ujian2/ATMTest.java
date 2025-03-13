package com.juaracoding.balboujian2testng.ujian2;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATMTest {

    private ATM atm;

    @BeforeMethod
    public void setUp() {
        // Menginisialisasi ATM dengan saldo awal sebesar 1000 sebelum setiap pengujian
        atm = new ATM(1000);
    }

    @Test
    public void testLihatSaldo() {
        // Memastikan saldo awal sesuai dengan nilai inisialisasi
        Assert.assertEquals(atm.lihatSaldo(), 1000.0);
    }

    @Test
    public void testSetorUang() {
        // Menguji penyetoran uang dengan jumlah valid
        atm.setorUang(500);
        Assert.assertEquals(atm.lihatSaldo(), 1500.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetorUangNegatif() {
        // Menguji penyetoran uang dengan jumlah negatif yang harus memicu pengecualian
        atm.setorUang(-100);
    }

    @Test
    public void testTarikUang() {
        // Menguji penarikan uang dengan jumlah valid
        atm.tarikUang(300);
        Assert.assertEquals(atm.lihatSaldo(), 700.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTarikUangLebihDariSaldo() {
        // Menguji penarikan uang yang melebihi saldo saat ini
        atm.tarikUang(1200);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTarikUangNegatif() {
        // Menguji penarikan uang dengan jumlah negatif yang harus memicu pengecualian
        atm.tarikUang(-50);
    }
}
