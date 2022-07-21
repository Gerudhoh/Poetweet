import React, { Component } from "react"
import './App.css';
import { createTheme, ThemeProvider } from '@mui/material/styles';

//Custom Components
import AppBar from "./Components/AppBar";
import HomePage from "./Components/HomePage";

const theme = createTheme({
  palette: {
      type: 'light',
      primary: {
          main: '#ec9daf',
      },
      secondary: {
          main: '#f50057',
      },
      background: {
          default: '#f6dddd',
      },
  },
  typography : {
    allVariants: {
      color: '#ec9daf'
    },
    color: '#ec9daf',
    fontFamily: 'Poppins',
    h1: {
      fontSize: '5.378em',
      color: '#ffffff'
    },
    h2: {
      fontSize: '3.842em',
    },
    h3: {
      fontSize: '2.744em',
      color: '#d7c0ad',
    },
    h4: {
      fontSize: '1.96em',
    },
    p: {
      fontSize: '1em',
    }
  },
  components: {
    MuiButton:{
      props:{
        color: 'primary',
      },
    },
    MuiCircularProgress: {
      props:{
        color: 'primary',
      },
    }
  }
});

class App extends Component {
  state = {
    poem: []
  };

  async componentDidMount() {
    const response = await fetch('/poem');
    const body = await response.json();
    this.setState({poem: body});
  }

  render() {
    return (
      <ThemeProvider theme={theme}>
        <div className="App">
            <AppBar/>
            <HomePage/>
          </div>
        </ThemeProvider>
    );
  }
}

export default App;
