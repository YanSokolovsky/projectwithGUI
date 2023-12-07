#include "AllThings.h"
#include <iostream>
#include <fstream>
#include <thread>
dataStruct::dataStruct(char* arra, int siz, int resmulti)
{
    array = arra;
    size = siz;
    lowerBound = ' ';
    upperBound = ' ';
    resultMulti = resmulti;
}
char* CreateNewArray(dataStruct* s)
{
    char* newArray = new char[s->size]; // Create a new array of size 'n'
    int index = 0; // Initialize an index to keep track of the new array

    // Iterate over the original array
    for (int i = 0; i < s->size; i++)
    {
        // Check if the ASCII value of the character is within the range [A, lowerBound]
        if (static_cast<int>(s->array[i]) - static_cast<int>(s->lowerBound) >= 0 && static_cast<int>(s->array[i]) - static_cast<int>(s->upperBound) <= 0)
        {
            newArray[index] = s->array[i]; // If so, add it to the new array
            index++; // Increment the index
        }
    }

    // Fill the rest of the new array with '*'
    for (int i = index; i < s->size; i++)
    {
        newArray[i] = '*';
    }

    return newArray; // Return the new array
};

int MultiplyNumericElements(dataStruct* s)
{
    int product = -1; // Initialize the product to -1

    // Iterate over the array
    for (int i = 0; i < s->size; i++)
    {
        // Check if the character is a digit
        if (static_cast<int>(s->array[i]) - static_cast<int>('0') >= 0 && static_cast<int>(s->array[i]) - static_cast<int>('0') <= 9)
        {
            // If the product is still -1, set it to 1
            if (product == -1)
                product = 1;

            // Multiply the product with the numeric value of the character
            product *= static_cast<int>(s->array[i]) - static_cast<int>('0');
        }
    }

    return product; // Return the product
};
void DisplayResult(int delay, char* newArray, dataStruct* s)
{
    std::cout << "Result of workstream from workstream: " << std::endl;

    // Iterate over the new array and print each character with a delay
    for (int i = 0; i < s->size; i++)
    {
        std::cout << newArray[i] << " ";
        std::this_thread::sleep_for(std::chrono::milliseconds(delay));
    }
};