🏡 StayIn – Automation Testing Framework

A full end-to-end Selenium + TestNG UI automation framework built for testing the StayIn Web Application.
The framework follows industry best practices including Page Object Model (POM), component-based architecture, custom driver manager, data-driven testing, logging, video recording, and Allure reporting.

📌 Features

✔ Selenium WebDriver (Chrome, Firefox, Edge, Safari)
✔ TestNG test runner + custom listeners
✔ Page Object Model (POM) architecture
✔ Custom WebDriver Factory & Thread-safe driver (ThreadLocal)
✔ JSON, Excel, Properties data readers
✔ Fluent wait & optimized element interaction manager
✔ Allure Reports + Environment Info + Screenshots
✔ Video recording for tests
✔ Soft & Hard Assertions (Validation + Verification classes)
✔ Support for local, headless, and remote (Selenium Grid) execution
✔ Clean reporting & execution pipelines


📂 Project Structure
StayIn-Automation-testing/
|
+-- src/
|   +-- main/
|   |   +-- java/
|   |   |   +-- ComponanatManger/
|   |   |   +-- Drivers/
|   |   |   +-- Listeners/
|   |   |   +-- Media/
|   |   |   +-- Utils/
|   |   |   +-- Validations/
|   |   +-- resources/
|   |       +-- configuration.properties
|   |
|   +-- test/
|       +-- java/
|       +-- resources/test-data/
|
+-- pom.xml
+-- README.md





🛠️ Technologies Used
| Category                 | Tools                                       |
| ------------------------ | ------------------------------------------- |
| **Automation**           | Selenium WebDriver, TestNG                  |
| **Build Tool**           | Maven                                       |
| **Reporting**            | Allure Reports                              |
| **Programming Language** | Java 21                                     |
| **Design Patterns**      | POM, Component-based pages, Factory pattern |
| **Logging & Utils**      | Log4j2, Custom utilities                    |
| **Test Recording**       | video-recorder-testng                       |
| **Data Handling**        | JSON, Excel, Properties                     |


🧪 Supported Test Scenarios



🧱 Framework Architecture Highlights
🔹 Custom GUIDriver
Handles driver creation for all browsers
Supports local / headless / remote Grid
Thread-safe for parallel execution

🔹 ElementActionManager
A robust wrapper around WebDriver:
Smart waits
Scroll before interaction
Retry on stale elements
JS scrolling
Text, upload, click, hover, dropdown, alerts

🔹 TestNG Listeners
Capture screenshots
Capture logs
Soft assertions via Validation class
Automatic Allure attachments
🔹 Data Reader Modules
✔ JSON (update & read)
✔ Excel
✔ Properties

👨‍💻 Author

Muhammed Sherif
Automation Engineer | Selenium | Java | TestNG | Appium
GitHub: https://github.com/mohsherif17

⭐ Contribute

Pull requests are welcome!
If you want enhancements (CI/CD, Docker Grid, parallel runs), feel free to ask.
