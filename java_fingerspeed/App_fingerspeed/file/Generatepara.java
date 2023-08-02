package App_fingerspeed.file;

import java.util.Random;

public class Generatepara {
    Random rand = new Random();
    String[] wran = { "Chờ đợi", "giải phóng", "dòng sông", "quan trọng", "đánh dấu", "điện", "khiếm khuyết", "xô",
            "màu xanh da trời", "thịt bò", "mùa xuân", "đau", "quả cam", "vui mừng",
            "sốt sắng", "hoa mỹ", "chính xác", "phanh", "tiêu đề", "tia X", "lễ hội", "phẫn nộ",
            "kéo", "hoà bình", "khó tính", "hình dạng", "xoa dịu", "cái đầu", "phát hiện", "không cần thiết",
            "thời gian", "dồi dào", "buồn tẻ", "miệng", "trót lọt", "nảy", "cám ơn", "tránh xa", "gây sốc",
            "người vị thành niên", "bí mật", "con thỏ", "bảo vệ", "Mật ong", "việc kinh doanh", "vô giá trị", "gợi ý",
            "lộng lẫy", "buồn tẻ", "an toàn", "khổng lồ", "đến", "cái trống", "ghét", "khủng long", "máy móc",
            "chế ngự", "làm phiền", "Điện thoại", "tấm màn", "con khỉ", "đồ đạc", "từ chối", "bữa trưa", "bằng gỗ",
            "sự đổ nát", "lời yêu cầu", "đã bị mờ", "trại", "giáo khoa", "khó chịu", "ngón tay", "chát", "công khai",
            "đèn", "dán", "hân hoan", "dốt", "hiện hữu", "điên cuồng", "nghi ngờ", "tăng", "bệnh sởi", "bạn", "rối rắm",
            "không thích", "xe đạp", "huyên náo", "hoàn thành", "cử động", "bờ biển", "không khí", "tuân theo", "nổ",
            "tò mò", "bao gồm", "màu vàng", "dài", "Bánh", "đóng", "giảng bài", "năm", "không mong muốn", "bí đao",
            "ranh giới", "ghi nhớ", "gà", "bù nhìn", "cà vạt", "hiện tại", "khá giả", "nhiều thịt", "tuyệt vời",
            "bút chì", "nhu cầu", "khuyên bảo", "mở to mắt", "xin lỗi", "khả thi", "thê lương", "da", "đá", "sân khấu",
            "lưỡi", "sưng húp", "trại", "trượt tuyết", "bóng ma", "nhanh nhất", "môi", "thường xuyên",
            "một", "có hiệu quả", "tức giận", "cáo buộc", "bộ đồ", "sổ tay", "lau đi", "mơ", "tia lửa",
            "công việc", "thùng", "ngai vàng",
            "không tự nhiên", "tái nhợt", "ngắn gọn", "vật nuôi", "đặc biệt", "đánh giá quá cao", "căn nhà",
            "phụ thuộc", "lộn xộn", "mục vụ", "buổi chiều", "mê hoặc", "căng thẳng", "quân đội", "không tì vết",
            "cái nút", "Tốt", "giảm bớt", "da thú", "mắt", "đốm", "sự phát triển", "báo động", "tuyên bố", "tràn ra",
            "ngọn lửa", "không đồng ý", "thì thầm", "sống động", "khỏe mạnh", "nghiêm trang", "thực vật", "tan chảy",
            "giật", "hiếu chiến", "ngũ cốc", "giả mạo", "chạy", "mờ", "nóng", "lớn", "kỳ lạ", "chóng mặt",
            "vô trách nhiệm", "khóa kéo", "hồng tước", "can đảm", "cuộc thi đấu", "hình thức", "cái lược", "đóng cửa",
            "vô nghĩa", "uể oải", "thất thường", "dừng lại", "voi ma mút", "ảo giác", "bình thường", "mạng nhện",
            "xác định", "rập khuôn",
            "bẩn thỉu", "bắt giữ", "tò mò", "thợ mộc", "bé nhỏ", "hoạt bát", "bảo vệ", "nghèo", "buồn cười",
            "lung lay", "vui vẻ", "trứng", "nhện", "phong phú", "hài hước", "dính", "nhựa", "chuột nhắt", "năng suất",
            "đồng ý", "cái nĩa", "nóng nảy", "chuẩn bị", "còi", "chịu trách nhiệm", "làm khô hạn", "tám", "tổ", "chậm",
            "ngông cuồng", "cái cưa", "nỗi sợ", "chà", "bay hơi", "bị mốc", "thu hút", "tiếp thu", "khác thường", "cổ",
            "người đàn ông", "cửa hàng", "nặng về vật chất", "nhún vai", "cuồn cuộn", "điều khiển", "du lịch",
            "nàng tiên", "vón cục", "thập cẩm", "cây cung", "đứa trẻ", "tham gia", "đầm", "sự ngạc nhiên", "thanh bình",
            "kỳ diệu", "lừng lẫy", "Yên tĩnh", "sự thật", "đĩa", "mềm mại", "che phủ", "bố", "quần dài", "ô tô",
            "hời hợt", "tục tĩu", "chết chìm", "ghen tị", "lãng phí", "tôn giáo", "chuông", "đá", "thông báo",
            "đàn hồi", "cạm bẫy", "sương khói", "sống động", "nghiêm trọng", "bắt đầu", "xa hoa", "lòng chảo", "cờ lê",
            "khóa", "hình ảnh", "tay", "đường sắt", "thú vị", "buôn bán", "cát", "khuôn mặt",
            "mong manh", "la hét", "sản xuất", "thấp", "trừ đi", "siêng năng", "vượt qua", "ga tàu", "rửa",
            "đồng nghĩa", "màu đỏ", "sai", "hiếu chiến", "thấp", "bao gồm", "hộp thư", "chất lỏng", "đắt", "sợi dây",
            "thời gian", "mở", "thừa nhận", "rau xà lách", "phán quyết", "tinh túy", "cao chót vót", "sao chép",
            "tốt hơn",
            "bánh ngọt", "mịn màng", "sợi", "dầu mỡ", "miền núi", "dán", "tham gia", "cục nước đá", "cô đọng", "nhựa",
            "quả lê", "âm học", "đột ngột", "chức vụ", "tia lửa", "uốn cong", "kẻ gian", "mèo con", "lén lút",
            "sử dụng", "sự ô nhiễm", "trần tục", "dã man",
            "Hân hoan", "xác thịt", "chim cổ đỏ", "buổi tiệc", "sữa", "tròn", "không may", "dễ thương", "sự đối đãi",
            "mùa đông", "nóng", "có sẵn", "xe lửa", "nhà văn", "văn xuôi", "lén lút", "xây dựng",
            "gia súc", "giàu có", "hỗn láo", "bọt biển", "khuôn mặt", "phản quang", "con gấu", "mong muốn", "nhộn nhịp",
            "dẻo dai", "đầy nước mắt", "thôi miên", "ốm", "hoạt hình", "xanh tươi", "con cóc", "mở khóa", "lâu dài",
            "tường", "thảm khốc", "săn bắn", "có thể đạt được", "đi bộ", "chất tẩy trắng", "tay không", "xảy ra", "hôn",
            "lừa", "nữ hoàng",
            "biết rõ", "thương tiếc", "cô gái", "khung", "dựng lên", "thư ký", "cánh đồng", "hữu ích", "khoa học",
            "vương miện", "xông lên", "kỳ cục", "đầm", "bằng cấp", "cái đệm", "cay", "bẩm sinh", "quảng trường",
            "cây xương rồng", "khó khăn",
            "công ty", "đáng chú ý", "tính toán", "rửa sạch", "tội phạm", "xô", "tâm trí", "trắng trợn",
            "người đàn ông", "cho phép làm gì", "lý thuyết", "chu đáo", "cái thùng", "ngon",
            "khác thường", "không đáng kể", "bóng đèn tròn", "tối ưu", "cái lò", "hóa chất", "nông", "thương xót",
            "đau", "phá thai", "vĩnh viễn", "khoanh vùng", "mắt", "chán", "mệt", "hối tiếc", "phù hợp", "khoai tây",
            "bối rối", "ngây thơ", "tĩnh mạch", "âm thanh",
            "tấn công", "trao đổi", "mặt sau", "kiểm tra", "Bị hư hại", "bà ngoại", "phân công", "hấp dẫn", "họng",
            "văn phòng", "ghim", "nhìn chằm chằm", "xen vào", "rùng mình", "can thiệp", "xảy ra", "hố", "đường",
            "Bài kiểm tra", "mù", "miễn phí", "trình diễn", "Quả anh đào", "hương vị", "kỳ diệu", "mục đích", "mở rộng",
            "rủi ro", "cuồng tín", "bẩn thỉu", "ăn xin", "lãng mạn", "tàn nhẫn", "nhanh", "bồn tắm", "phòng", "túi",
            "đằng trước", "hoa", "cát", "lún", "đánh", "dấu", "chắc chắn", "kiên quyết", "bức thư", "chuyên gia",
            "không may", "mắt xanh mong", "nhai", "máu" };

    public String generate() {
        String para = "";
        for (int i = 0; i <= 120; i++) {
            int n = rand.nextInt(500);
            if (para.length() == 0) {
                para = wran[n];
            } else {
                para = para + " " + wran[n];
            }
        }
        return para;
    }
}
