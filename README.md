# Seam Carving for Content-Aware Image Resizing

Seam carving is a novel way to crop images without losing important content in the image. This is often 
called “content-aware” cropping or image retargeting. Its an algorithm that lets you go 

## TechStack

Simply, Written code in python language and executed on google colab

## Algorithm

We have used concept of Dynamic Programming 
Firstly, 
1. Assign an energy value to every pixel
2. Find a connected path of the pixels with the least energy
3. Delete all the pixels in the path
4. Repeat 1-3 till the desired number of rows/columns are deleted

## Future Scope

1. We would like to extend our approach to other domains, first of which 
would be resizing of video.
2. we would like to investigate the possibility to combine the two
approaches, specifically to define more robust multi-size images.
3. we would also like to find a better way to combine horizontal and vertical
seams in multi-size images

## Results

From this

![boat](https://github.com/Patilsanika/Content_Aware_Image_Resize/assets/86789929/f55967a0-b6ed-418c-a311-0d6f7bb4eee9)



Energy Map
![energy](https://github.com/Patilsanika/Content_Aware_Image_Resize/assets/86789929/6b19d6d6-dd0a-4bef-98e0-7933789b9b9f)



Seam
![Seampath](https://github.com/Patilsanika/Content_Aware_Image_Resize/assets/86789929/ca1fab27-6aca-45d0-be87-18d5c3f71e53)





![resized](https://github.com/Patilsanika/Content_Aware_Image_Resize/assets/86789929/62847cab-d789-4b99-93bf-f8a63487c086)

As you can see, most of the important content in the image: the boats, have been left intact.
The algorithm removed some of the rock formations and the water(leading to the boats appearing nearer to each other).
