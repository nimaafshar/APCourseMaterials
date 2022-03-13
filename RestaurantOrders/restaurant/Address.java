package restaurant;


public class Address {
    public double longitude, latitude;
    public String written_address;


    public Address(double longitude, double latitude, String written_address) throws Exception {
        this.longitude = longitude;
        this.latitude = latitude;
        if (written_address == null || written_address.equals("")) {
            throw new Exception("written address is null");
        }
        this.written_address = written_address;
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    private double distance_from(Address a) {
        double lat1 = this.latitude;
        double lon1 = this.longitude;
        double lat2 = a.latitude;
        double lon2 = a.longitude;

        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        // converting to km
        dist = dist * 1.609344;
        return (dist);
    }
}
