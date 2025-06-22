-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 22 Jun 2025 pada 12.09
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `autoclean_javadesk`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `akun`
--

CREATE TABLE `akun` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `akun`
--

INSERT INTO `akun` (`id`, `username`, `password`) VALUES
(1, 'admin', 'adminganteng'),
(2, 'Fadhil', '12345678'),
(3, 'aidan', '12345678'),
(4, 'Fadhil Sw', '12345678'),
(5, 'check', '12345678'),
(6, 'Arta', '12345678'),
(7, 'Artha', '12345678'),
(8, 'COY', '12345678'),
(9, 'morgan', 'swarigading'),
(10, 'user', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f'),
(11, 'pelanggan', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f'),
(12, 'Fahriel', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f'),
(13, 'Bintang', '477e8b6cb16ab3fe04da261d7242667a29fb1391e2b814b53c40c2c375b23f7b'),
(14, 'Alif', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f'),
(15, 'username', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f'),
(16, 'nama', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `no_telp` varchar(20) DEFAULT NULL,
  `tipe_kendaraan` enum('Roda dua','Roda Empat') NOT NULL,
  `merk_kendaraan` varchar(50) DEFAULT NULL,
  `plat_kendaraan` varchar(20) DEFAULT NULL,
  `opsi_pencucian` enum('Level 1 (Low Service) - Rp. 20.000','Level 2 (Mid Service) - Rp. 50.000','Level 3 (Full Service) - Rp. 100.000') NOT NULL,
  `jadwal_cuci` date DEFAULT NULL,
  `status` enum('Belum dibayar','Sedang dicuci','Selesai','Dibatalkan') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`id`, `username`, `no_telp`, `tipe_kendaraan`, `merk_kendaraan`, `plat_kendaraan`, `opsi_pencucian`, `jadwal_cuci`, `status`) VALUES
(6, 'morgan', '585674453859', 'Roda dua', 'HONDA', 'BJ 8999 G', '', '2025-06-10', 'Belum dibayar'),
(7, 'morgan', '085824104213', 'Roda Empat', 'Honda', 'B 1289 JUR', '', '2025-06-02', 'Belum dibayar'),
(8, 'morgan', '085824104213', 'Roda Empat', 'Honda', 'B 1289 JUR', '', '2025-06-02', 'Belum dibayar'),
(9, 'morgan', '02938193123', 'Roda dua', 'Honda', 'A 3R0X BOS', '', '2025-06-09', 'Belum dibayar'),
(10, 'user', '085891236731', 'Roda dua', 'Honda', 'B 1234 ABC', '', '2025-06-17', 'Sedang dicuci'),
(11, 'user', '98209182', 'Roda Empat', 'Honda', 'B 1234 BHD', 'Level 2 (Mid Service) - Rp. 50.000', '2025-06-03', 'Sedang dicuci'),
(12, 'user', '085819414122', 'Roda dua', 'Beat', 'K 1231 HHH', 'Level 2 (Mid Service) - Rp. 50.000', '2025-06-05', 'Sedang dicuci'),
(13, 'user', '0858191213831', 'Roda Empat', 'Daihatsu', 'B 4121 JRI', 'Level 1 (Low Service) - Rp. 20.000', '2025-07-01', 'Sedang dicuci'),
(15, 'Fahriel', '098324732492894', 'Roda Empat', 'Honda', 'B 6969 JVA', 'Level 3 (Full Service) - Rp. 100.000', '2025-06-10', 'Sedang dicuci'),
(16, 'Fahriel', '0982192131', 'Roda dua', 'Honda Vario', 'B 1249 HUH', 'Level 2 (Mid Service) - Rp. 50.000', '2025-06-02', 'Sedang dicuci'),
(17, 'Fahriel', '0128183131', 'Roda Empat', 'Honda', 'B 8128 BHH', 'Level 3 (Full Service) - Rp. 100.000', '2025-06-09', 'Sedang dicuci'),
(19, 'user', '08484813809', 'Roda dua', 'Yamaha', 'B W4HY U', 'Level 2 (Mid Service) - Rp. 50.000', '2025-07-01', 'Sedang dicuci'),
(20, 'Bintang', '1204823923', 'Roda Empat', 'Ferrari', 'B 5UL TAN', 'Level 2 (Mid Service) - Rp. 50.000', '2025-07-23', 'Belum dibayar'),
(22, 'nama', '08127731831', 'Roda dua', 'honda', 'B 1234 ABC', 'Level 3 (Full Service) - Rp. 100.000', '2025-06-16', 'Dibatalkan'),
(24, 'nama', '09890812398213', 'Roda dua', 'Yamaha', 'B 1234 HGH', 'Level 1 (Low Service) - Rp. 20.000', '2025-07-01', 'Dibatalkan'),
(25, 'user', '083813890912', 'Roda Empat', 'Hyundai', 'B 1236 UHU', 'Level 2 (Mid Service) - Rp. 50.000', '2025-06-11', 'Selesai');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indeks untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `akun`
--
ALTER TABLE `akun`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
