// Packages
import * as React from 'react';
import { useState } from 'react';

//Material UI Components
import Typography from '@mui/material/Typography';
import TextField from '@mui/material/TextField';
import Stack from '@mui/material/Stack';

//Custom Components
import PoemTypeCardList from "./PoemTypeCardList";

export default function PoemSelection() {
    const [twitterHandle, setTwitterHandle] = useState(null);
      return (
        <Stack alignItems="center" spacing={1}>
          <Typography variant="h4">Input the Twitter Handle of the Person whose tweets you wish to turn into poetry</Typography>
            <TextField id="twitter-handle" label="Twitter Handle" variant="outlined" placeholder="dog_feelings" 
                sx={{
                   width: { sm: 200, md: 300 }, 
                   textAlign: 'center'
                }}
                onChange={(event) => {
                    setTwitterHandle(event.target.value);
                    console.log(event);
                }}
                />

            {twitterHandle === null ? (
                     <Typography variant="h4"></Typography>
                ) : (
                <Stack>
                    <Typography variant="h4">Select Which Type of Poem you'd like to Compose</Typography>
                    <PoemTypeCardList />
                </Stack>
                )}
        </Stack>
      );
  }