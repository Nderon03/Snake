# Snakee Yipee — Nderon Beqiri

## 🎮 Project Description

This project is inspired by the classic game **Snake** and features numerous levels, each posing a unique challenge.

At the start of the program:
- Players are shown an **all-time score list** and the scores to beat.
- Users can select a **snake color**, **level**, **background**, and enter a **username** before clicking **Begin**.
- If unsure how to start, clicking **Rules** brings up an instructional screen.
- Once the game ends, the final score is displayed.
- Rerunning the program allows players to compare scores, as results are saved to the list.

---

## 🛠 Installing and Running the Project

1. Create a new Java project in **IntelliJ**, using **Java SDK 19**.
2. Copy and paste the `src/` folder from the ZIP into the project's `src/`.
3. Navigate to `File → Project Structure → Libraries` and add:
   - Java: `javafx-sdk-19`
   - Java: `apiguardian-api:1.1.2`
   - Maven: `jlayer-1.0.14.jar`
4. Add **JUnit 4** and **JUnit 5.8.1** to the classpath.
5. Copy `AllTimeScores.txt` to the root of the project (same level as `src/`).
6. Run the `main` class using **Current File Configuration** in IntelliJ.

---

## 🎯 How to Play

- Control the snake using the **arrow keys** or **WASD**.
- **Eat food** to increase your score.
- Avoid:
  - Hitting obstacles or borders.
  - Colliding the snake's head with its own body.
- The game ends upon collision. Try to reach the highest score possible!

---

## 🙏 Credits

- [DigitalOcean](https://www.digitalocean.com/)
- [Stack Overflow](https://stackoverflow.com/)

---

> Built with passion and bugs by Nderon Beqiri 🐍
