import React from "react"
import {BrowserRouter} from "react-router-dom";
import './App.css';
import { createTheme, ThemeProvider } from '@mui/material/styles';

//Custom Components
import AppBar from "./Components/AppBar";
import RouteSwitch from "./Components/RouteSwitch";

export default function App () {
  const theme = createTheme({
    palette: {
        type: 'light',
        primary: {
            main: '#ec9daf',
            contrastText: '#ec9daf'
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
      MuiLink: {
        props:{
          color: 'primary.contrastText',
        }
      },
      MuiCircularProgress: {
        props:{
          color: 'primary',
        },
      }
    }
  });

  // const navigate = useNavigate();
    return (
      <ThemeProvider theme={theme}>
        <div className="App">
        <BrowserRouter>
          <AppBar />
          <RouteSwitch />
          </BrowserRouter>
          </div>
        </ThemeProvider>
    );
}
