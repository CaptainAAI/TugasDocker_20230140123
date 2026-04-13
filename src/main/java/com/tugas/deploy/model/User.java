package com.tugas.deploy.model;

public class User {
    private final int no;
    private final String nama;
    private final String nim;
    private final String jenisKelamin;

    public User(int no, String nama, String nim, String jenisKelamin) {
        this.no = no;
        this.nama = nama;
        this.nim = nim;
        this.jenisKelamin = jenisKelamin;
    }

    public int getNo() {
        return no;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }
}

