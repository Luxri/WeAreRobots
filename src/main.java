public class main {

    public class World implements Runnable {

        private World w;
        

        public World(int w, int h) {
            this.w = new World(w, h);
        }

        private void draw(World w) {
            for (int y = 0 ; y < w.getHeight() ; y++) {
                String s = "";
                for (int x = 0; x < w.getWidth(); x++) {
                    s += (""+(w.getCellStatusAt(x,y)?"X":" "));
        }

        public static void main(String[] args) {

        }
    }

}