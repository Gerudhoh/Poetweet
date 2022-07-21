
import * as React from 'react';

import { useState, useEffect } from 'react';
import { useLocation } from 'react-router-dom'

//Material UI Components
import Stack from '@mui/material/Stack';
import Typography from '@mui/material/Typography';
import CircularProgress from '@mui/material/CircularProgress';

export default function PoemGeneration(props){
    const [isLoading, setLoading] = useState(true);
    const [poem, setPoem] = useState(null);

    async function fetchPoem(data) {
        setLoading(true);
        const response = await fetch('/poem/haiku', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({ "twitterId": data }),
        });
        response.json().then(data => { 
            setPoem(data.map(line => line.text));
            console.log(poem);
        });
    }

    return(
        <React.Fragment>
        {isLoading ? (
            <Stack alignItems="center" spacing={2}>
                <CircularProgress size={100}/>
            </Stack>
          ) : (
            <Typography>{poem}</Typography>
          )}
        </React.Fragment>
      );
}