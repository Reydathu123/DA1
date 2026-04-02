create database ShopGiay_YA
go
use ShopGiay_YA



---thongtinsanpham
create table thuong_hieu(idthuonghieu int identity (1,1) primary key,
mathuonghieu varchar(40) unique,
tenthuonghieu nvarchar(40),
trangthaian bit
)
INSERT INTO thuong_hieu (mathuonghieu, tenthuonghieu, trangthaian) VALUES
('TH001', N'Nike', 1),
('TH002', N'Adidas', 1),
('TH003', N'Converse', 1),
('TH004', N'Puma', 1),
('TH005', N'Vans', 1);


create table loai_giay(
idloaigiay int identity (1,1) primary key,
maloaigiay varchar (40) unique,
tenloaigiay nvarchar(40),
trangthaian bit
)
INSERT INTO loai_giay (maloaigiay, tenloaigiay, trangthaian) VALUES
('LG001', N'Sneaker', 1),
('LG002', N'Sandal', 1),
('LG003', N'Boot', 1);

create table kich_co (
idkichco int identity (1,1) primary key,
makichco varchar(40) unique,
tenkichco nvarchar(40),
trangthaian bit
)
INSERT INTO kich_co (makichco, tenkichco, trangthaian) VALUES
('KC001', N'38', 1),
('KC002', N'39', 1),
('KC003', N'40', 1),
('KC004', N'41', 1),
('KC005', N'42', 1);




create table gioi_tinh(
idgioitinh int identity (1,1) primary key,
magioitinh varchar(40) unique,
tengioitinh nvarchar(40),
trangthaian bit
)
INSERT INTO gioi_tinh (magioitinh, tengioitinh, trangthaian) VALUES
('GT001', N'Nam', 1),
('GT002', N'Nữ', 1);




create table mau_sac(
idmausac int identity(1,1) primary key,
mamausac varchar(40) unique,
tenmausac nvarchar(40),
trangthaian bit
)
INSERT INTO mau_sac (mamausac, tenmausac, trangthaian) VALUES
('MS001', N'Đen', 1),
('MS002', N'Trắng', 1),
('MS003', N'Xám', 1);


create table xuat_xu(
idxuatxu int identity(1,1) primary key,
maxuatxu varchar(40) unique,
tenxuatxu nvarchar(40),
trangthaian bit

)
INSERT INTO xuat_xu (maxuatxu, tenxuatxu, trangthaian) VALUES
('XX001', N'Việt Nam', 1),
('XX002', N'Trung Quốc', 1),
('XX003', N'Mỹ', 1);




create table chat_lieu(
idchatlieu int identity(1,1) primary key,
machatlieu varchar(40) unique,
tenchatlieu nvarchar(40),
trangthaian bit
)
INSERT INTO chat_lieu (machatlieu, tenchatlieu, trangthaian) VALUES
('CL001', N'Da', 1),
('CL002', N'Vải', 1),
('CL003', N'Nhựa', 1);






create table loai_de_giay(
idloaidegiay int identity(1,1) primary key,
maloaidegiay varchar(40) unique,
tenloaidegiay nvarchar(40),
trangthaian bit
)
INSERT INTO loai_de_giay (maloaidegiay, tenloaidegiay, trangthaian) VALUES
('LDG001', N'Đế cao su', 1),
('LDG002', N'Đế EVA', 1);




create table day_giay(
iddaygiay int identity(1,1) primary key,
madaygiay varchar(40) unique,
tendaygiay nvarchar(40),
trangthaian bit
)
INSERT INTO day_giay (madaygiay, tendaygiay, trangthaian) VALUES
('DG001', N'Dây vải', 1),
('DG002', N'Dây tròn', 1);





create table kieu_dang(
idkieudang int identity(1,1) primary key,
makieudang varchar(40) unique,
tenkieudang nvarchar(40),
trangthaian bit
)
INSERT INTO kieu_dang (makieudang, tenkieudang, trangthaian) VALUES
('KD001', N'Thể thao', 1),
('KD002', N'Lịch sự', 1);



---end thong tin sp
create table vai_tro(
idvaitro int identity (1,1) primary key,
mavaitro varchar(40) unique,
tenvaitro nvarchar(40),
trangthaian bit
)
INSERT INTO vai_tro (mavaitro, tenvaitro, trangthaian) VALUES
('VT001', N'Nhân viên', 1),
('VT002', N'Quản lý', 1);


create table nhan_vien(
idnhanvien int identity (1,1) primary key,
idvaitro int,
foreign key (idvaitro) references vai_tro(idvaitro),
manhanvien varchar(40) unique,
hovaten nvarchar(60),
anh varchar(100),
ngaysinh date,
cccd varchar(30),
gioitinh bit,
diachi nvarchar(100),
email varchar(50),
sodienthoai varchar(11),
nguoithem varchar(40),
nguoisua varchar(40),
nguoixoa varchar(40),
ngaytao datetime,
ngaysua datetime,
ngayxoa datetime,
trangthaian bit,
matkhau varchar(50)
)
INSERT INTO nhan_vien (idvaitro, manhanvien, hovaten, anh, ngaysinh, cccd, gioitinh, diachi, email, sodienthoai, nguoithem, ngaytao,trangthaian,matkhau )
VALUES
(2, 'NV002', N'Qly', 'avatar2.png', '2001-11-01', '00123456789', 1, N'123 Trinh Van Bo, Hanoi', 'qly@gmail.com', '0909000001', 'qly', GETDATE(),1,'123');

(1, 'NV001', N'Admin', 'avatar1.png', '2006-01-01', '00123456789', 1, N'123 Trinh Van Bo, Hanoi', 'admin1@gmail.com', '0909000001', 'admin', GETDATE(),1,'123');






create table dia_chi_khach_hang(
iddiachi int  identity (1,1) primary key,
madiachikhachhang varchar(40) unique,
diachicuthe nvarchar(40),
phuongxa nvarchar(40),
quanhuyen nvarchar(40),
tinhthanh nvarchar(40),
ghichu nvarchar(100),
nguoithem varchar(40),
nguoisua varchar(40),
nguoixoa varchar(40),
ngaythem datetime,
ngaysua datetime,
ngayxoa datetime,
trangthaian bit 
);
INSERT INTO dia_chi_khach_hang (madiachikhachhang, diachicuthe, phuongxa, quanhuyen, tinhthanh, ghichu, nguoithem, ngaythem,trangthaian)
VALUES
('DCKH001', N'123 Lý Thường Kiệt', N'Phường 1', N'Quận 10', N'TP.HCM', N'Giao giờ hành chính', 'admin', GETDATE(),1),
('DCKH002', N'88 Nguyễn Huệ', N'Phường Bến Nghé', N'Quận 1', N'TP.HCM', N'Sáng giao', 'admin', GETDATE(),1),
('DCKH003', N'15 Trần Phú', N'Phường 4', N'Quận 5', N'TP.HCM', N'Liên hệ trước', 'admin', GETDATE(),1),
('DCKH004', N'56 Võ Văn Tần', N'Phường 6', N'Quận 3', N'TP.HCM', N'Nhận tại nhà', 'admin', GETDATE(),1),
('DCKH005', N'77 Pasteur', N'Phường 8', N'Quận 1', N'TP.HCM', N'Nhận buổi tối', 'admin', GETDATE(),1);





create table khach_hang(
idkhachhang int identity (1,1) primary key,
iddiachi int,
foreign key (iddiachi) references dia_chi_khach_hang(iddiachi),
makhachhang varchar(40) unique,
hovaten nvarchar(40),
ngaysinh date,
sodienthoai varchar(11),
email varchar(40),
gioitinh bit,
nguoithem varchar(40),
nguoisua varchar(40),
nguoixoa varchar(40),
ngaythem datetime,
ngaysua datetime,
ngayxoa datetime,
trangthaian bit
);
INSERT INTO khach_hang (iddiachi, makhachhang, hovaten, ngaysinh, sodienthoai, email, gioitinh, nguoithem, ngaythem,trangthaian)
VALUES
(1, 'KH001', N'Nguyễn Văn A', '2007-05-20', '0912345678', 'a1@gmail.com', 1, 'admin1', GETDATE(),1),
(2, 'KH002', N'Lê Thị B', '1995-08-15', '0911222333', 'b1@gmail.com', 0, 'admin1', GETDATE(),1),
(3, 'KH003', N'Trần Văn C', '2005-12-01', '0909123456', 'c1@gmail.com', 1, 'admin1', GETDATE(),1),
(4, 'KH004', N'Phạm Thị D', '2001-03-18', '0987766554', 'd1@gmail.com', 0, 'admin1', GETDATE(),1),
(5, 'KH005', N'Hồ Văn E', '1989-10-25', '0977554433', 'e1@gmail.com', 1, 'admin1', GETDATE(),1);









create table san_pham(
	idsanpham int identity (1,1) primary key,
	masanpham varchar(40) unique,
	tensanpham nvarchar(100),
	mota nvarchar(100),
	trangthaisp bit,
	nguoithem varchar(40),
nguoisua varchar(40),
nguoixoa varchar(40),
ngaytao datetime,
ngaysua datetime,
ngayxoa datetime,
trangthaian bit
)
INSERT INTO san_pham (masanpham, tensanpham, mota, trangthaisp, nguoithem, ngaytao,trangthaian) VALUES
('SP001', N'Giày Nike Air', N'Mẫu thể thao mới nhất', 1, 'admin', GETDATE(),1),
('SP002', N'Giày Adidas UltraBoost', N'Giày chạy bộ êm ái', 1, 'admin', GETDATE(),1),
('SP003', N'Giày Converse Classic', N'Phong cách cổ điển', 1, 'admin', GETDATE(),1),
('SP004', N'Giày Puma RS-X', N'Kiểu dáng trẻ trung', 1, 'admin', GETDATE(),1),
('SP005', N'Giày Vans Old Skool', N'Mẫu giày trượt ván', 1, 'admin', GETDATE(),1);





create table san_pham_chi_tiet(
idsanphamchitiet  int identity(1,1) primary key,
idsanpham int,
foreign key (idsanpham) references san_pham(idsanpham),
idthuonghieu int,
foreign key (idthuonghieu) references thuong_hieu(idthuonghieu),
idloaigiay int,
foreign key (idloaigiay) references loai_giay(idloaigiay),
idkichco int,
foreign key (idkichco) references kich_co(idkichco),
idgioitinh int,
foreign key (idgioitinh) references gioi_tinh(idgioitinh),
idmausac int,
foreign key (idmausac) references mau_sac(idmausac),
idxuatxu int,
foreign key (idxuatxu) references xuat_xu(idxuatxu),
idchatlieu int,
foreign key (idchatlieu) references chat_lieu(idchatlieu),
idloaidegiay int,
foreign key (idloaidegiay) references loai_de_giay(idloaidegiay),
iddaygiay int,
foreign key (iddaygiay ) references day_giay(iddaygiay ),
idkieudang int,
foreign key (idkieudang) references kieu_dang(idkieudang),
masanphamchitiet varchar(100) unique,
giaban money,
soluong int,
trangthai bit
)

-- Sản phẩm 1: tổng 20
INSERT INTO san_pham_chi_tiet (idsanpham, idthuonghieu, idloaigiay, idkichco, idgioitinh, idmausac, idxuatxu,
  idchatlieu, idloaidegiay, iddaygiay, idkieudang, masanphamchitiet, giaban, soluong, trangthai) VALUES
(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 'SPCT001', 1200000, 10, 1),
(1, 1, 1, 2, 2, 2, 2, 2, 1, 1, 1, 'SPCT002', 1200000, 10,  1);

-- Sản phẩm 2: tổng 25
INSERT INTO san_pham_chi_tiet VALUES
(2, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 'SPCT003', 1350000, 15, 1),
(2, 2, 1, 3, 2, 2, 1, 2, 2, 2, 1, 'SPCT004', 1350000, 10,  1);

-- Sản phẩm 3: tổng 15
INSERT INTO san_pham_chi_tiet VALUES
(3, 3, 2, 3, 1, 1, 1, 1, 2, 1, 1, 'SPCT005', 850000, 8,  1),
(3, 3, 2, 4, 2, 3, 2, 2, 1, 2, 2, 'SPCT006', 850000, 7,  1);

-- Sản phẩm 4: tổng 30
INSERT INTO san_pham_chi_tiet VALUES
(4, 4, 1, 5, 1, 1, 3, 2, 1, 2, 2, 'SPCT007', 1500000, 15, 1),
(4, 4, 1, 4, 2, 2, 2, 2, 2, 1, 1, 'SPCT008', 1500000, 15, 1);

-- Sản phẩm 5: tổng 18
INSERT INTO san_pham_chi_tiet VALUES
(5, 5, 3, 3, 1, 3, 2, 1, 1, 2, 2, 'SPCT009', 900000, 8,1),
(5, 5, 3, 4, 2, 2, 1, 2, 1, 1, 1, 'SPCT010', 900000, 10, 1);




create table phieu_giam_gia(
idphieugiamgia int identity(1,1) primary key,
maphieugiamgia varchar(40) unique,
tenphieugiamgia nvarchar(100),
loaigiamgia bit,
giatrigiam float,
dontoithieu money,
giamtoida float,
soluong int,
thoigianbatdau date,
thoigianketthuc date,
trangthaipgg bit,
nguoitao varchar(40),
nguoisua varchar(40),
nguoixoa varchar(40),
ngaytao datetime,
ngaysua datetime,
ngayxoa datetime,
trangthaian bit
)
INSERT INTO phieu_giam_gia (maphieugiamgia, tenphieugiamgia, loaigiamgia, giatrigiam, dontoithieu, giamtoida, soluong, thoigianbatdau, thoigianketthuc, trangthaipgg, nguoitao, ngaytao,trangthaian)
VALUES
('GG001', N'Giảm 10%', 1, 10, 1000000, 300000, 100, '2025-07-01', '2025-07-31', 1, 'admin', GETDATE(),1),
('GG002', N'Giảm 200K', 0, 200000, 2000000, 200000, 50, '2025-07-05', '2025-07-30', 1, 'admin', GETDATE(),1);





create table dia_chi_phieu_nguoi_nhan (
iddiachiphieunguoinhan int identity(1,1) primary key,
tenguoinhan nvarchar(40),
diachichitietnguoinhan nvarchar(100),
sodienthoainguoinhan varchar(11),
phuongnguoinhan nvarchar(30),
huyennguoinhan nvarchar(30),
tinhnguoinhan nvarchar(30),
ghichunguoinhan nvarchar(50),
trangthaian bit
)
INSERT INTO dia_chi_phieu_nguoi_nhan (tenguoinhan, diachichitietnguoinhan, sodienthoainguoinhan, phuongnguoinhan, huyennguoinhan, tinhnguoinhan, ghichunguoinhan,trangthaian)
VALUES
(N'Nguyễn Văn A', N'123 Lê Lợi', '0911111111', N'Phường 7', N'Quận 3', N'TP.HCM', N'Giao sáng',1),
(N'Lê Thị B', N'45 Nguyễn Đình Chiểu', '0922222222', N'Phường 5', N'Quận 1', N'TP.HCM', N'Giao chiều',1),
(N'Trần Văn C', N'78 Trần Hưng Đạo', '0933333333', N'Phường 10', N'Quận 5', N'TP.HCM', N'Giao tối',1),
(N'Phạm Thị D', N'12 Hai Bà Trưng', '0944444444', N'Phường 3', N'Quận 1', N'TP.HCM', N'Giao giờ hành chính',1),
(N'Hồ Văn E', N'90 Lê Văn Sỹ', '0955555555', N'Phường 8', N'Quận Phú Nhuận', N'TP.HCM', N'Giao linh hoạt',1);




create table hinh_thuc_thanh_toan (
    idhinhthucthanhtoan int identity(1,1) primary key,
    mahinhthucthanhtoan varchar(20) unique,
    tenhinhthucthanhtoan nvarchar(60),
    nguoithem varchar(50),
    nguoisua varchar(50),
    nguoixoa varchar(50),
    ngaythem datetime,
    ngaysua datetime,
    ngayxoa datetime,
	trangthaian bit
);
INSERT INTO hinh_thuc_thanh_toan ( mahinhthucthanhtoan, tenhinhthucthanhtoan, nguoithem, nguoisua, nguoixoa, ngaythem, ngaysua, ngayxoa,trangthaian)
VALUES
('HTTT01', N'Tiền mặt', 'admin', NULL, NULL, '2025-06-29', NULL, NULL,1),
('HTTT02', N'Chuyển khoản', 'admin', NULL, NULL, '2025-06-23', NULL, NULL,1),
('HTTT03', N'Tiền mặt & Chuyển khoản', 'admin', NULL, NULL, '2025-06-27', NULL, NULL,1);



create table phuong_thuc_thanh_toan (
    idphuongthucthanhtoan int identity(1,1) primary key,
    idhinhthucthanhtoan int,
	  FOREIGN KEY (idhinhthucthanhtoan) REFERENCES hinh_thuc_thanh_toan(idhinhthucthanhtoan),
    sotienthanhtoan money,
    trangthai bit
  
)

INSERT INTO phuong_thuc_thanh_toan (idhinhthucthanhtoan, sotienthanhtoan, trangthai)
VALUES
(1, 2400000, 1), -- tiền mặt
(2, 2700000, 1), -- chuyển khoản
(3, 1350000, 1); -- kết hợp



create table phieu_giam_gia_khach_hang(
idphieugiamgiakh int identity (1,1) primary key,
idkhachhang int,
foreign key(idkhachhang) references khach_hang(idkhachhang),
idphieugiamgia int,
foreign key(idphieugiamgia) references phieu_giam_gia(idphieugiamgia),
nguoitao varchar(40),
nguoisua varchar(40),
ngaytao varchar(40),
ngaysua varchar(40),
trangthaian bit
);
INSERT INTO phieu_giam_gia_khach_hang (idkhachhang, idphieugiamgia, nguoitao, ngaytao, trangthaian)
VALUES
(1, 1, 'admin', CONVERT(varchar, GETDATE(), 120), 1),
(2, 2, 'admin', CONVERT(varchar, GETDATE(), 120), 1);




create table hoa_don(
idhoadon int identity(1,1) primary key,
idnhanvien int,
foreign key(idnhanvien) references nhan_vien(idnhanvien),
idkhachhang int,
foreign key(idkhachhang) references khach_hang(idkhachhang),

idphuongthucthanhtoan int,
foreign key(idphuongthucthanhtoan) references phuong_thuc_thanh_toan(idphuongthucthanhtoan),
idphieugiamgia int,
foreign key(idphieugiamgia) references phieu_giam_gia(idphieugiamgia),
iddiachiphieunguoinhan int,
foreign key(iddiachiphieunguoinhan) references dia_chi_phieu_nguoi_nhan(iddiachiphieunguoinhan),
mahoadon varchar(40) unique,
loaihoadon bit,
ngayxuathoadon datetime,
tongtienchuagiam money,
sotiengiamgia money,
tongtiensaugiam money,
ghichu nvarchar(40),
trangthai int,
nguoithem varchar(40),
nguoisua varchar(40),
nguoixoa varchar(40),
ngaythem datetime,
ngaysua datetime,
ngayxoa datetime,
trangthaian bit
);
-- HD001: có mã giảm giá GG001 (10%)
-- HD002: có mã giảm giá GG002 (200k)
-- HD003: không có mã giảm giá
-- HD004: không có mã giảm giá
-- HD005: có mã giảm giá GG001
-- HD006: có mã giảm giá GG002

INSERT INTO hoa_don (idnhanvien, idkhachhang, idphuongthucthanhtoan, idphieugiamgia, iddiachiphieunguoinhan,
mahoadon, loaihoadon, ngayxuathoadon, tongtienchuagiam, sotiengiamgia, tongtiensaugiam,
ghichu, trangthai, nguoithem, ngaythem ,trangthaian) VALUES
(1, 1, 1, 1, 1, 'HD001', 0, GETDATE(), 2400000, 240000, 2160000, N'Tại quầy', 0, 'admin', GETDATE(),1),
(1, 2, 2, 2, 2, 'HD002', 1, GETDATE(), 2700000, 200000, 2500000, N'Giao hàng', 0, 'admin', GETDATE(),1),
(1, 3, 3, NULL, 3, 'HD003', 0, GETDATE(), 1350000, 0, 1350000, N'Không giảm giá', 2, 'admin', GETDATE(),1),
(1, 4, 1, NULL, 4, 'HD004', 1, GETDATE(), 1700000, 0, 1700000, N'Tại nhà', 0, 'admin', GETDATE(),1),
(1, 1, 2, 1, 5, 'HD005', 0, GETDATE(), 2400000, 240000, 2160000, N'Mua lần 2', 0, 'admin', GETDATE(),1),
(1, 2, 3, 2, 2, 'HD006', 1, GETDATE(), 2700000, 200000, 2500000, N'Thanh toán lại', 0, 'admin', GETDATE(),1);





create table hoa_don_chi_tiet (
    idhoadonchitiet int identity(1,1) primary key ,
	idhoadon int,
	foreign key (idhoadon) references hoa_don(idhoadon),
    idsanphamchitiet int,
	 FOREIGN KEY (idsanphamchitiet) REFERENCES san_pham_chi_tiet(idsanphamchitiet),
    mahoadonchitiet varchar(50) unique,
    dongia money,
    soluong int,
    thanhtien money,
	trangthaian bit
   )

   -- Mỗi hóa đơn 1–2 sản phẩm chi tiết

INSERT INTO hoa_don_chi_tiet (idhoadon, idsanphamchitiet, mahoadonchitiet, dongia, soluong, thanhtien,trangthaian) VALUES
(1, 1, 'HDCT001', 1200000, 2, 2400000,1),
(2, 3, 'HDCT002', 1350000, 2, 2700000,1),
(3, 4, 'HDCT003', 1350000, 1, 1350000,1),
(4, 5, 'HDCT004', 850000, 2, 1700000,1),
(5, 2, 'HDCT005', 1200000, 2, 2400000,1),
(6, 3, 'HDCT006', 1350000, 1, 1350000,1),
(6, 5, 'HDCT007', 850000, 1, 850000,1),
(6, 6, 'HDCT008', 850000, 1, 850000,1); -- HD006 có 3 sản phẩm







create table lich_su_hoa_don(
idlichsuhoadon int identity (1,1) primary key,
idhoadon int,
foreign key (idhoadon) references hoa_don(idhoadon),
motahoatdong nvarchar(100),
nguoithem varchar(40),
nguoisua varchar(40),
ngaytao datetime,
ngaysua datetime,
trangthai bit
)