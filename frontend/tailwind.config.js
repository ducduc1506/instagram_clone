/** @type {import('tailwindcss').Config} */
module.exports = {
  darkMode: "class", // 👈 Bắt buộc để dùng dark mode qua class
  content: [
    "./app/**/*.{js,ts,jsx,tsx}",
    "./components/**/*.{js,ts,jsx,tsx}",
    "./features/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {},
  },
  plugins: [],
};
