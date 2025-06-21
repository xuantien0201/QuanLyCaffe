package Controller;

import Object.HoaDon;
import Model.HoaDonModel;

public class HoaDonController {
    private HoaDonModel hoaDonModel;

    public HoaDonController() {
        hoaDonModel = new HoaDonModel();
    }

    public boolean themHoaDon(HoaDon hoaDon) {
        return hoaDonModel.themHoaDon(hoaDon);
    }
}
