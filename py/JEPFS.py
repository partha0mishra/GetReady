# JEPFS
## start ## 
# fizzbuzz (from, to, step, fizzNum, buzzNum, fizzLabel, buzzLabel) 
# + type hints
# + function help text
# testfizzbuzz ()
# breakfast list, print, change, append, remove index, remove item, add duplicates, remove, list comprehensions -> capitalize()/ upper()/ len() based filter
# breakfst dict, print, unpack as tuple
# arbitrary arguments
# arbitrary keyword arguments
# len()/ min()/ max()
# class, constructor, method, change value of a variable
## end   ##

# unit 02
print("Hello, world!")
print("one") # comment
"""A really long string
with multiple lines"""
'ice cream'
"he said 'sorry' again"
'i love '+" to eat "+"""ice cream""" # string concatenation
# bool int float str
type(True) # type()
type('723')
best_food='ice cream' # PEP8 -> snake case. Variables can't start with a number/ symbol
print(_BEST_FOOD) # 
print("The best food ever is " + best_food + " , especially when it's hot outside!") # without f-string
print(f"The best food ever is {best_food} , especially when it's hot outside!") # f-string
232 == 232 # checking for equality
723 != 723 # other comparison operator can be > < >= <= 
type(best_food) == str # true : Type-checking
# note: ASSERT halts execution when the result is false
assert type(best_food) == str, f"expected best_food to be of type str but found {type(best_food)} instead"

# lab 02
conversion_rate = 1.18 # Create the variable conversion_rate and assign it the value of 1.18
assert type(conversion_rate) == float, f"expected conversion_rate to be of type float, found to be {type(conversion_rate)} instead" # assert type
euro_amount = 567 # Create the variable euro_amount and assign it the value of 567
usd_amount = euro_amount * conversion_rate # Assign the result of the computation to usd_amount
assert usd_amount == 669.06, "Incorrect amount." # Test with Assertion
print(f"{euro_amount} Euros is equal to ${usd_amount} USD")

# unit 03 : conditionals & loops
breakfast_list=["pancakes", "eggs", "waffles"] # declare
print(breakfast_list) # print entire list
for food in breakfast_list: # looping through each element and printing
    print(food)
for i in range(0,5): # stops before 5.
    print(i) # prints from 0 to 4 in separate line

# conditionals: if / elif/ else
food = "bacon"

if food != "eggs":
  if food == "waffles" or food == "pancakes":
    print(f"I need syrup for my {food}")
  else:
    print(f"I don't know what to do with {food}")
else:
  print("Make scrambled eggs")
  
print("All done")

# loops
for food in breakfast_list:
    print(food)

# lab 03 : FIZZ BUZZ test
for num in range(1, 101):
  if num %3 == 0 and num%5 ==0:
    print("FizzBuzz")
  elif num %3 == 0:
    print("Fizz")
  elif num%5  == 0:
    print("Buzz")
  else:
    print(num)

# clearing REPL screen
import os
clear = lambda: os.system('cls')
clear()

# Unit 04: Methods, Functions, Packages
def printEvenOdd(num):
    """ Prints the strings 'Even', 'Odd' or 'Unknown'. """
    if num %2 ==0:
        print("Even")
    elif num %2 == 1:
        print("Odd")
    else:
        print("Unknown")

result=printEvenOdd(42)
print(result) # prints None

# adding RETURN expression + help content
def documentedEvenOdd(num):
  """
  Returns the string "even", "odd", or "UNKNOWN".
  
  This would be a more verbose description of 
  what this function might do and could drone 
  one for quite a while
  
  Args:
    num (int): The number to be tested as even or odd
    
  Returns:
    str: "even" if the number is even, "odd" if the number is odd or "UNKNOWN"
    
  Examples:
    evenOdd(32)
    evenOdd(13)
  """
    
  if num % 2 == 0:
    return "even"
  elif num % 2 == 1:
    return "odd"
  else:
    return "UNKNOWN"

result=evenOdd(42)
print(f"The result is {result}")

# TESTS
result = evenOdd(101)
assert "odd" == result, f"Expected odd, found {result}"
print("Test #1 passed")

result = evenOdd(400)
assert "even" == result, f"Expected even, found {result}"
print("Test #2 passed")

result = evenOdd(5)
assert "odd" == result, f"Expected odd, found {result}"
print("Test #3 passed")

result = evenOdd(2)
assert "even" == result, f"Expected even, found {result}"
print("Test #4 passed")

result = evenOdd(3780) 
assert "even" == result, f"Expected even, found {result}"
print("Test #5 passed")

result = evenOdd(78963)
assert "odd" == result, f"Expected odd, found {result}"
print("Test #6 passed")

# A slighly more robust version:
value = 1/3
expected = "UNKNOWN"
result = evenOdd(value)
assert expected == result, f"Expected {expected}, found {result} for {value}"
print("Test #7 passed")

# multiple parameters - supplying labels for even and odd
def evenOddInt(num, evenLabel, oddLabel):
  if num % 2 == 0:
    return evenLabel
  elif num % 2 == 1:
    return oddLabel
  else:
    return "UNKNOWN"

# execute the function by passing it a number and two labels
print( evenOddInt(41, "even", "odd") )
print( evenOddInt(42, "even", "odd") )

# Defining a function to help us with Unit Testing
def testEvenOddInt(value, evenLabel, oddLabel, expected):
  result = evenOddInt(value, evenLabel, oddLabel)
  
  assert expected == result, f"Expected {expected}, found {result} for {value}"
  print(f"Test {value}/{evenLabel}/{oddLabel} passed")

# Testing UNKNOWN case
testEvenOddInt(1/3, "what", "ever", "UNKNOWN")

# Test around zero
testEvenOddInt(-1, "even", "odd", "odd")
testEvenOddInt(0, "even", "odd", "even")
testEvenOddInt(1, "even", "odd", "odd")
testEvenOddInt(2, "even", "odd", "even")
testEvenOddInt(3, "even", "odd", "odd")

# Additional tests focused on the even/odd labels
testEvenOddInt(400, "pair", "impair", "pair")
testEvenOddInt(5, "zυγός", "περιττός", "περιττός")
testEvenOddInt(2, "gerade", "ungerade", "gerade")
testEvenOddInt(3780, "genap", "ganjil", "genap")
testEvenOddInt(78963, "sudé", "liché", "liché")

# Type hints
def evenOddInt(num:int, evenLabel:str, oddLabel:str) -> str:
  if num % 2 == 0:
    return evenLabel
  elif num % 2 == 1:
    return oddLabel
  else:
    return "UNKNOWN"

# execute the function by passing it a number
evenOddInt(42, "even", "odd")

# Unfortunately, the type hints are not Enforced
resultA = evenOddInt(12, "EVEN", "ODD")
print(f"""The result is "{resultA}" and of type {type(resultA)}""")

resultB = evenOddInt(13, True, False)
print(f"""The result is "{resultB}" and of type {type(resultB)}""")

resultC = evenOddInt(17, 1, 0)
print(f"""The result is "{resultC}" and of type {type(resultC)}""")

# Adding default values for the parameters
def evenOddInt(num: int, evenLabel:str = "even", oddLabel:str = "odd") -> str:
  if num % 2 == 0:
    return evenLabel
  elif num % 2 == 1:
    return oddLabel
  else:
    return "UNKNOWN"

# execute the function by passing it a number
print(evenOddInt(42))
print(evenOddInt(32, "EVEN", "ODD"))
print(evenOddInt(65, "pair", "impair"))
# Named Parameter passing
evenOddInt(e='eo',num=42,o='oo')
evenOddInt(42,o='oo',e='ee') # Also

# Arbitrary arguments
def sum(*args):
  total = 0
  for value in args:
    total += value
  return total

sum_a = sum(1, 2, 3, 4, 5)
sum_b = sum(32, 123, -100, 9)
sum_c = sum(13)
sum_d = sum()

print(f"Example A: {sum_a}")
print(f"Example B: {sum_b}")
print(f"Example C: {sum_c}")
print(f"Example D: {sum_d}")

# Arbitrary KeyWord arguments
def my_func(**kwargs):
  print("Arguments received:")
  for key in kwargs: # key -> name of the argument
    value = kwargs[key] # kwargs[key] -> value of that key passed
    print(f"  {key:15s} = {value}")
  print()

my_func(first_name="Jeff", last_name="Lebowski", drink="White Russian")

my_func(movie_title="The Big Lebowski", release_year=1998)

# method => function on object
name='Partha'
name.upper()
name.count('a')

# Libraries
import numpy
numpy.sqrt(9)

import numpy as np
np.sqrt([1,4,9])

# lab 04
# function fizzBuzz, parameter int, return str
# guard for paramter type to be int
def fizzBuzz(num: int) -> str:
  assert type(num) == int, f"Expected num to be int but found {type(num)}"
  
  if (num %5 ==0) and (num %3 ==0):
    return 'FizzBuzz'
  elif (num %5 ==0):
    return 'Buzz'
  elif (num %3 ==0):
    return 'Fizz'
  else:
    return f"{num}" # converting to string

# Tests
expected = "Fizz"
result = fizzBuzz(3)
assert type(result) == str, f"Expected actual to be of type str, but found {type(result)}."
assert result == expected, f"""Expected "{expected}", but found "{result}"."""

expected = "Buzz"
result = fizzBuzz(5)
assert type(result) == str, f"Expected actual to be of type str, but found {type(actresultual)}."
assert result == expected, f"""Expected "{expected}", but found "{result}"."""

expected = "FizzBuzz"
result = fizzBuzz(15)
assert type(result) == str, f"Expected actual to be of type str, but found {type(result)}."
assert result == expected, f"""Expected "{expected}", but found "{result}"."""

expected = "7"
result = fizzBuzz(7)
assert type(result) == str, f"Expected actual to be of type str, but found {type(result)}."
assert result == expected, f"""Expected "{expected}", but found "{result}"."""

def testFizzBuzz(num: int, expected: str):        # Declare the function testFizzBuzz
  result = fizzBuzz(num) # Call fizzBizz() with the specified value
  assert type(result) == str, f"Expected result to be of type str but found to be {type(result)}"   # Assert that the result is of type str
  assert result == expected, f"""Expected result to be "{expected}" but found "{result}" """   # Assert that the result matches the expected value

test_numbers = [0, 1, 2, 3, 5, 15]
expectations = ["FizzBuzz", "1", "2", "Fizz", "Buzz", "FizzBuzz"]

for i in range(0,len(test_numbers)):
  num = test_numbers[i]
  expected = expectations[i]
  print(f"""Test[{i}]  Number: {num} Expected: '{expected}'""")
  testFizzBuzz(num, expected)

# Unit 05
# Lists - 0-based index
breakfast_list = ["pancakes", "apple", "eggs"]
print(breakfast_list)

first_item = breakfast_list[0]
second_item = breakfast_list[1]
thrid_item = breakfast_list[2]
# non_existant_item = breakfast_list[3] # gives IndexError: list index out of range

print(f"""The first item is "{first_item}".""")
print(f"""The second item is "{second_item}".""")
print(f"""The third item is "{thrid_item}".""")

# len()
list_length = len(breakfast_list)         # first determine the length of the list
last_item = breakfast_list[list_length-1] # minus one because we are a zero-based index

print(f"The list has {list_length} items in it.")
print(f"""The last item is "{last_item}".""")

third_item_v2 = breakfast_list[-1] # going back from the end
second_item_v2 = breakfast_list[-2]
first_item_v2 = breakfast_list[-3]


print(f"""From the end, the thrid item is "{third_item_v2}".""")
print(f"""From the end, the second item is "{second_item_v2}".""")
print(f"""From the end, the first item is "{first_item_v2}".""")
# Alter
breakfast_list = ["pancakes", "apple", "eggs"]
print(f"Before the update: {breakfast_list}")

# Replace pancakes with waffles
breakfast_list[0] = "waffles" 
print(f"After the update:  {breakfast_list}")

# Append
breakfast_list = ["pancakes", "apple", "eggs"]
print(f"Before the append: {breakfast_list}")

# Append an item to the end of the list
breakfast_list.append("oatmeal")

print(f"After the append:  {breakfast_list}")
# Delete item at an index
breakfast_list = ["pancakes", "apple", "eggs"]
print(f"Before the delete: {breakfast_list}")

# Remove the eggs (the last item in the list) to go vegan
del breakfast_list[2]
# del breakfast_list[-1]

print(f"After the delete:  {breakfast_list}")
# Remove - specify the Element/ Value
breakfast_list = ["pancakes", "eggs", "apple"]
print(f"Before the remove: {breakfast_list}")

# Remove the eggs, wherever it may be
breakfast_list.remove("eggs")

print(f"After the remove:  {breakfast_list}")
breakfast_list.append("test")
breakfast_list.append("test")
breakfast_list.append("tea")
breakfast_list.append("test")
print(f"Before the remove: {breakfast_list}")
breakfast_list.remove("test") # Removed only the first occurence
print(f"After the remove:  {breakfast_list}")

# Contains
breakfast_list = ["pancakes", "eggs", "apple"]

if "apple" in breakfast_list:
  print("You had an apple for breakfast.")

if "bacon" not in breakfast_list:
  print("You did not have bacon for breakfast.")

# built-in functions: len(), min(), max()
breakfast_list = ["pancakes", "eggs", "apple", "chicken"]

item_count = len(breakfast_list)
item_min = min(breakfast_list)
item_max = max(breakfast_list)

print(f"You had {item_count} items for breakfast")
print(f"""The "min" value in the list is "{item_min}".""")
print(f"""The "max" value in the list is "{item_max}".""")

# different results for different data types
some_numbers = [1, 32, 22, 54, 21, 32, 30]

item_count = len(some_numbers)
min_value = min(some_numbers)
max_value = max(some_numbers)

print(f"You had {item_count} items for breakfast")
print(f"""The "min" value in the list is {min_value}.""")
print(f"""The "max" value in the list is {max_value}.""")

# Range: IMMUTABLE
# Note that a range includes the start value and excludes the stop value
# A range from 1 up to but not including 5 (exclusive)
for i in range(1, 5):
  print(f"This is item #{i}")

# range starts from 0 by Default
for i in range(5):
  print(f"This is item #{i}")
# Step through the increments
# Only even numbers between 0 & 10 exclusive
for i in range(0, 10, 2):
  print(f"This is item #{i}")
# Every 3rd number, counting backwards, starting with 12
for i in range(12, 0, -3):
  print(f"This is item #{i}")
# List Comprehensions (converting one list to another) using For--in
breakfast_list = ["pancakes", "eggs", "apple", "chicken"]
print(f"Before transformation: {breakfast_list}")

caps_list = []  # Create an empty list
      
for item in breakfast_list:
  caps_list.append(item.capitalize()) # Capitalizes the first letter
  
print(f"After transformation:  {caps_list}")
# More compact
breakfast_list = ["pancakes", "eggs", "apple", "chicken"]
print(f"Before transformation: {breakfast_list}")

comp_caps_list = [item.capitalize() for item in breakfast_list]

print(f"After transformation:  {comp_caps_list}")
# Comprehension with Filter
breakfast_list = ["pancakes", "eggs", "apple", "chicken"]
print(f"Before filtering: {breakfast_list}")

comp_caps_list = [item.capitalize() for item in breakfast_list]

short_list = [item.upper() for item in breakfast_list if len(item) >= 7]
print(f"After filtering:  {short_list}")
# Dictionary === Map
breakfast_dict = {
  "eggs": 160,
  "apple": 100,
  "pancakes": 400,
  "waffles": 300,
}
print(breakfast_dict)
# Access
choice = "apple"
apple_calories = breakfast_dict[choice]

print(f"Your {choice} had {apple_calories} calories.")
# KeyError for non-existent keys
breakfast_dict["oatmeal"]
# get() returns None when key doesn't exist.
# a Default return value can also be specified
choiceA = "oatmeal"
caloriesA = breakfast_dict.get(choiceA, -1)
print(f"Your {choiceA} had {caloriesA} calories.")

choiceB = "waffles"
caloriesB = breakfast_dict.get(choiceB, -1)
print(f"Your {choiceB} had {caloriesB} calories.")
# contains => in/ not in
print(f"Original dictionary: {breakfast_dict}")

choice = "bacon"

if choice in breakfast_dict:
  print(f"{choice.upperCase()} has {breakfast_dict[choice]} calories")
  
elif choice not in breakfast_dict:
  print(f"""I couldn't find "{choice}" in the dictionary""")
  
else:
  print("This logically cannot happen :-)")
## Insert/ Update/ Delete
breakfast_dict = {"eggs": 160, "apple": 100, "pancakes": 400, "waffles": 300,}
print(f"Before insert: {breakfast_dict}")

# Insert orange juice with 110 calories
breakfast_dict["orange juice"] = 110
print(f"After insert:  {breakfast_dict}")

# Update the calorie count for pancakes
breakfast_dict["pancakes"] = 350
print(f"After update:  {breakfast_dict}")

# Delete the waffles
del breakfast_dict["waffles"]
print(f"After delete:  {breakfast_dict}")

# Iterate-01 using for -- in
for food in breakfast_dict:
  print(f"{food:13} {breakfast_dict[food]}")
# Iterate-02 unpacking using items() -> returns dict_items type -> subtype of Tuple
print("Food          Calories")
for key_value in breakfast_dict.items():
  key = key_value[0]
  value = key_value[1]
  print(f"{key:13} {value}")

## unpacking of tuples
my_tuple = ("Smith", 39)    # Create your own tuple
last_name, age = my_tuple   # Unpack the tuple

print(f"Name: {last_name}") # Print the last name
print(f"Age:  {age}")       # Print the age

## unpack dict_items as tuples
print("Food          Calories")
for food, calories in breakfast_dict.items():
  print(f"{food:13} {calories}")

## class
help(dict)

## class, object and methods
class Thing:
  def greet(self, greeting="Hello!"):
    print(f'{self} says, "{greeting}"') # self -> referencing the object

thing1 = Thing()  # Create an instance of Thing
thing2 = Thing()  # Create another Thing

thing1.greet()                # Call the greet() method on thing1
thing2.greet("Guten Tag!")    # Call the greet() method on thing2

# class, constructor, properties, methods
class Person:
  
  # Defining the class constructor method
  def __init__(self, first_name, last_name):
    # Here we create the properties on self with the values provided in the constructor
    self.first_name = first_name
    self.last_name = last_name
  
  # Defining other class methods
  def greet(self, greeting="Hello!"):
    print(f'{self.first_name} says, "{greeting}"')
    
  def full_name(self):
    return self.last_name + ", " + self.first_name

person1 = Person("Ming-Na", "Wen")
person2 = Person(first_name="Anil", last_name="Kapoor")
person3 = Person("Walter", "Carlos")

person1.greet()
person2.greet("Hi!")

print()

print(f"person3's current name: {person3.full_name()}")
person3.first_name = "Wendy"  # You can change the value of object properties
print(f"person3's updated name: {person3.full_name()}")

# Lab 05: wordcount
# input: list of words. output: map of {word, count}
def item_count(input):
  output = {}          # Initialize an empty dictionary
  
  for item in input:   # Iterate over the list of values
    current_count=output.get(item, 0)            # Update the dictionary
    output[item]=current_count+1
      
  return output        # Return the dictionary

# tests
empty_list = []
empty_count_result = {}
assert item_count(empty_list) == empty_count_result

breakfast_list = ["pancake", "egg", "egg", "pancake", "coffee", "pancake"]
breakfast_count_result = {"pancake": 3, "egg": 2, "coffee": 1, }
assert item_count(breakfast_list) == breakfast_count_result

print("Congratulations! All tests passed.")

# %%
