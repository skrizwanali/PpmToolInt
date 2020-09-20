import React from "react";
import Dashboard from "./components/Dashboard";
import Header from "./components/Layout/Header";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  return (
    <div className="App">
      <Header />
      <Dashboard />
    </div>
  );
}

export default App;
