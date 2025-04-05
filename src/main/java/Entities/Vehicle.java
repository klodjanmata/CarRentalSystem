package Entities;

    public class Vehicle {
        private int id;
        private String make;
        private String model;
        private int year;
        private String licensePlate;
        private double dailyRate;
        private boolean isAvailable;

        public Vehicle(int id, String make, String model, int year, String licensePlate, double dailyRate, boolean isAvailable) {
            this.id = id;
            this.make = make;
            this.model = model;
            this.year = year;
            this.licensePlate = licensePlate;
            this.dailyRate = dailyRate;
            this.isAvailable = isAvailable;
        }

        private int getId() {
            return id;
        }

        private String getMake() {
            return make;
        }

        private void setMake(String make) {
            this.make = make;
        }

        private String getModel() {
            return model;
        }

        private void setModel(String model) {
            this.model = model;
        }

        private int getYear() {
            return year;
        }

        private void setYear(int year) {
            this.year = year;
        }

        private String getLicensePlate() {
            return licensePlate;
        }

        private void setLicensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
        }

        private double getDailyRate() {
            return dailyRate;
        }

        private void setDailyRate(double dailyRate) {
            this.dailyRate = dailyRate;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public void setAvailable(boolean available) {
            isAvailable = available;
        }

        @Override
        public String toString() {
            return id + ": " + make + " " + model + " (" + year + ") - " + licensePlate +
                    " - $" + dailyRate + "/day - Available: " + isAvailable;
        }
    }
