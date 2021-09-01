package ru.job4j.stream;

public class Computer {
    private String motherboard;
    private Cpu cpu;
    private String graphics;
    private String hdd;
    private int ram;
    private String power;

    static class Builder {
        private String motherboard;
        private Cpu cpu;
        private String graphics;
        private String hdd;
        private int ram;
        private String power;

        public Builder buildMotherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        public Builder buildCpu(Cpu cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder buildGraphics(String graphics) {
            this.graphics = graphics;
            return this;
        }

        public Builder buildHdd(String hdd) {
            this.hdd = hdd;
            return this;
        }

        public Builder buildRam(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder buildPower(String power) {
            this.power = power;
            return this;
        }

        public Computer build() {
            Computer computer = new Computer();
            computer.motherboard = motherboard;
            computer.cpu = cpu;
            computer.graphics = graphics;
            computer.hdd = hdd;
            computer.ram = ram;
            computer.power = power;
            return computer;
        }
    }

    @Override
    public String toString() {
        return "Computer{"
                + "motherboard='" + motherboard + '\''
                + ", cpu='" + cpu + '\''
                + ", graphics='" + graphics + '\''
                + ", hdd='" + hdd + '\''
                + ", ram='" + ram + '\''
                + ", power='" + power + '\''
                + '}';
    }
}
