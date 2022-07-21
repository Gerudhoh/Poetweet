// Packages
import * as React from 'react';

//Material UI Components
import Typography from '@mui/material/Typography';
import Stack from '@mui/material/Stack';

//Custom Components
import PoemTypeCardList from "./PoemTypeCardList";

export default function PoemSelection() {
      return (
        <Stack alignItems="center" spacing={1}>
          <Stack>
              <Typography variant="h4">Select Which Type of Poem you'd like to Compose</Typography>
              <PoemTypeCardList />
          </Stack>
        </Stack>
      );
  }