A versatile, native Android application developed as Oasis Infobyte Internship Project 1 to provide accurate and quick unit conversions across major measurement categories.

💡 Project Overview
This application offers a dynamic and efficient way to convert values in Length, Weight/Mass, and Temperature. The core strength lies in its modular Java logic and user-friendly interface that adapts instantly to the selected measurement category.
This is an excellent idea for making your GitHub repository complete and professional. Adding sections for Tools Used, Steps Performed, Project Structure, and Outcome will provide a full picture of your development process.

Here is the enhanced content to add to your README.md:

🛠️ Tools & Technologies Used
The application was developed using industry-standard tools for Android mobile development, ensuring compatibility and best practices.

Integrated Development Environment (IDE): Android Studio

(The official IDE for Android development, providing the necessary tools for coding, debugging, and building the APK).

Programming Language: Java

(Used for implementing all the core application logic, including the conversion methods and UI event handling).

User Interface Markup: XML

(Used for defining the structure and appearance of the application's layout (activity_main.xml)).

Build System: Gradle

(Used for managing project dependencies and automating the build process).
This is an excellent idea for making your GitHub repository complete and professional. Adding sections for Tools Used, Steps Performed, Project Structure, and Outcome will provide a full picture of your development process.

Here is the enhanced content to add to your README.md:

🛠️ Tools & Technologies Used
The application was developed using industry-standard tools for Android mobile development, ensuring compatibility and best practices.

Integrated Development Environment (IDE): Android Studio

(The official IDE for Android development, providing the necessary tools for coding, debugging, and building the APK).

Programming Language: Java

(Used for implementing all the core application logic, including the conversion methods and UI event handling).

User Interface Markup: XML

(Used for defining the structure and appearance of the application's layout (activity_main.xml)).

Build System: Gradle

(Used for managing project dependencies and automating the build process).

🪜 Steps Performed (Development Workflow)
The development followed a standard Android application workflow:

Project Setup: Created a new Android Studio project with an Empty Activity template.

UI Design (XML): Designed activity_main.xml to include the following key UI elements:

An EditText (editTextText3) for user input.

Three Spinners (spinner, spinner2, spinner3) for category, source unit, and target unit selection.

A Button (button) to trigger the conversion.

A TextView (textView) to display the result.

Core Logic (Java - onCreate): Initialized all UI components and set up the ArrayAdapter for the Category Spinner.

Dynamic Unit Loading: Implemented the categorySpinner.setOnItemSelectedListener to dynamically load the appropriate unit arrays (LENGTH_UNITS, WEIGHT_UNITS, TEMP_UNITS) into the source and target unit Spinners.

Conversion Functions: Wrote dedicated private methods (convertLength, convertWeight, convertTemperature) to isolate and manage the specific mathematical logic for each category.

Event Handling: Implemented the convertButton.setOnClickListener to call the main logic in performConversion().

Finalization: Added input validation and result formatting (to two decimal places) in the performConversion() method.

🔑 Key Features of the Application
Comprehensive Coverage: Converts units across Length (cm, m, km), Weight/Mass (mg, g, kg), and Temperature (C, F, K).

Dynamic UI: The unit options available to the user change automatically based on the selected category, providing a highly tailored and responsive user experience.

Modular Codebase: Conversion logic is separated into distinct, reusable functions, making the code easy to read, test, and maintain.

Accurate Logic: Utilizes standard conversion formulas and pivots through base units (Meter, Kilogram, Celsius) for consistent and reliable results.

Error Handling: Includes a Toast message to warn the user if a non-numeric or empty value is entered.
📂 Project Structure
The project adheres to the standard Android Studio structure, making it familiar and easy to navigate for other developers.

DirectoryContentDescriptionapp/src/main/java/com.example.oasisunitconverter/MainActivity.javaCore Application Logic. 

Contains all UI initialization, event listeners, and the three primary conversion methods.

app/src/main/res/layout/activity_main.xmlUser Interface. 

Defines the layout and arrangement of all Spinners, the input field, button, and result display.app/src/main/res/values/strings.xml, colors.xmlResources.

 Stores text, color definitions, and other constants used throughout the application.app/src/main/AndroidManifest.xmlConfiguration. 

Declares the MainActivity and essential application metadata.
✅ Outcome
The project successfully delivers a fully functional, single-screen unit converter Android application that meets all specified requirements for the three core measurement categories. It demonstrates proficiency in:

Android UI development using XML (Spinner, EditText).

Implementing conditional logic and event handling in Java.

Applying mathematical formulas for accurate scientific conversion.

Adhering to a clean, modular code structure for scalability
________________________
submitted by:Anuraj vijayan k
intership Role:Android development
Task Number:Task1
