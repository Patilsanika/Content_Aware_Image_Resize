
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageSeamCarving {

    public static void main(String[] args) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("images/boat.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        int h = image.getHeight();
        int w = image.getWidth();

        // Part I - Extract the energy out of the image.
        int[][][] data = new int[h][w][3];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int rgb = image.getRGB(j, i);
                data[i][j][0] = (rgb >> 16) & 0xFF;
                data[i][j][1] = (rgb >> 8) & 0xFF;
                data[i][j][2] = rgb & 0xFF;
            }
        }

        int[][] energyMatrix = extractEnergy(data);
        int[][] backTrack = seamPath(data, energyMatrix);

        data = carveImage(data, energyMatrix, backTrack);

        // Convert data back to BufferedImage
        BufferedImage resultImage = new BufferedImage(w - 1, h, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w - 1; j++) {
                int rgb = (data[i][j][0] << 16) | (data[i][j][1] << 8) | data[i][j][2];
                resultImage.setRGB(j, i, rgb);
            }
        }

        try {
            ImageIO.write(resultImage, "png", new File("resized.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[][] extractEnergy(int[][][] imgArray) {
        // Implement your energy extraction logic here
        int h = imgArray.length;
        int w = imgArray[0].length;
        int[][] energyMatrix = new int[h][w];
        // Calculate energy values
        // ...
        return energyMatrix;
    }

    private static int[][] seamPath(int[][][] data, int[][] energyMat) {
        // Implement your seam path calculation logic here
        int h = data.length;
        int w = data[0].length;
        int[][] backTrack = new int[h][w];
        // Calculate seam path
        // ...
        return backTrack;
    }

    private static int[][][] carveImage(int[][][] data, int[][] energyMat, int[][] backTrack) {
        int h = data.length;
        int w = data[0].length - 1; // Reduce width by 1 after seam removal
        int[][][] carvedData = new int[h][w][3];
    
        for (int i = 0; i < h; i++) {
            int colToRemove = backTrack[i][0]; // Get the column index to remove
            int colIdx = 0;
    
            for (int j = 0; j < w; j++) {
                if (j == colToRemove) {
                    colIdx++; // Skip this column
                }
    
                carvedData[i][j][0] = data[i][colIdx][0]; // Red
                carvedData[i][j][1] = data[i][colIdx][1]; // Green
                carvedData[i][j][2] = data[i][colIdx][2]; // Blue
    
                colIdx++;
            }
        }
    
        return carvedData;
    }
    

    // Other helper methods and functions can be added here
}

