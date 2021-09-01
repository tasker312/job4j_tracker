package ru.job4j.stream;

public class Cpu {
    private String socket;
    private int frequency;
    private int cores;
    private int cache;

    static class Builder {
        private String socket;
        private int frequency;
        private int cores;
        private int cache;

        public Builder buildSocket(String socket) {
            this.socket = socket;
            return this;
        }

        public Builder buildFrequency(int frequency) {
            this.frequency = frequency;
            return this;
        }

        public Builder buildCores(int cores) {
            this.cores = cores;
            return this;
        }

        public Builder buildCache(int cache) {
            this.cache = cache;
            return this;
        }

        public Cpu build() {
            Cpu cpu = new Cpu();
            cpu.socket = socket;
            cpu.frequency = frequency;
            cpu.cores = cores;
            cpu.cache = cache;
            return cpu;
        }
    }

    @Override
    public String toString() {
        return "Cpu{"
                + "socket='" + socket + '\''
                + ", frequency=" + frequency
                + ", cores=" + cores
                + ", cache=" + cache
                + '}';
    }
}
