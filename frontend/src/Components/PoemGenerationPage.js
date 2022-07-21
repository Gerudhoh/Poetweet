
import * as React from 'react';

import { useState } from 'react';
import { useLocation } from 'react-router-dom'
import {Link} from 'react-router-dom';

//Material UI Components
import Stack from '@mui/material/Stack';
import Typography from '@mui/material/Typography';
import TextField from '@mui/material/TextField';
import CircularProgress from '@mui/material/CircularProgress';
import Button from '@mui/material/Button';
import { styled } from '@mui/material/styles';
import Paper from '@mui/material/Paper';


// Custom Components
import PoemCard from "./PoemCard"

const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#ffbec7',
  ...theme.typography.body2,
  padding: theme.spacing(1),
  textAlign: 'center',
  color: theme.palette.text.secondary,
}));

export default function PoemGeneration(props){
    const [isLoading, setLoading] = useState(false);
    const [twitterHandle, setTwitterHandle] = useState(null);
    const [poem, setPoem] = useState(null);
    const location = useLocation()

    async function fetchPoem() {
        const data = location.state;
        console.log(data);
        setLoading(true);
        const response = await fetch('/poem/haiku', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({ "twitterId": twitterHandle }),
        });
        response.json().then(data => { 
            return(
              <Item sx={{
                width: { sm: 200, md: 300 }, 
                textAlign: 'center'
              }}>
              <PoemCard poem={data}/>
              </Item>
              );
          }).then( resource => {
            setPoem(resource);
            setLoading(false);
          });
    }

    return(
        <React.Fragment>
          {poem === null ? (
              <Stack alignItems="center" spacing={1}>
              <Typography variant="h4">Input the Twitter Handle of the Person whose tweets you wish to turn into poetry</Typography>
              <TextField id="twitter-handle" label="Twitter Handle" variant="outlined" placeholder="dog_feelings" 
                  sx={{
                    width: { sm: 200, md: 300 }, 
                    textAlign: 'center'
                  }}
                  onChange={(event) => {
                      setTwitterHandle(event.target.value);
                  }}
                  />
                  {twitterHandle === null 
                  ? (
                    <Typography variant="h4"></Typography>
                  ) 
                  : (
                    <Button variant="outlined" onClick={() => fetchPoem()}>Write Poem</Button>
                    )
                  }
            </Stack>
          ) : (
            <Stack alignItems="center" spacing={2}>
            </Stack>
          )}
        {isLoading ? (
              <CircularProgress size={100}/>
          ) : (
            <Stack alignItems="center" spacing={2}>
              <Typography variant="h2"></Typography>
              {poem}
            </Stack>
          )}
        </React.Fragment>
      );
}