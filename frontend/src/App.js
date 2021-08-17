import React, { Component } from "react"
import logo from './logo.svg';
import './App.css';

class App extends Component {
  state = {
    poem: []
  };

  async componentDidMount() {
    console.log("test!");
    const response = await fetch('/poem');
    const body = await response.json();
    debugger;
    this.setState({poem: body});
  }

  render() {
    const {poem} = this.state;
    return (
        <div className="App">
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            { <div className="App-intro">
              <h2>poem</h2>
              {poem.map(line =>
                  <div>
                    {line.text}
                  </div>
              )}
            </div> }
          </header>
        </div>
    );
  }
}

export default App;
