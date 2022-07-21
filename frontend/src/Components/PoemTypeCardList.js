import * as React from 'react';

//Material UI Components
import Box from '@mui/material/Box';
import { styled } from '@mui/material/styles';
import Grid from '@mui/material/Grid';
import Paper from '@mui/material/Paper';

//Custom Components
import PoemTypeCard from "./PoemTypeCard";

const Item = styled(Paper)(({ theme }) => ({
    backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#ffbec7',
    ...theme.typography.body2,
    padding: theme.spacing(1),
    textAlign: 'center',
    color: theme.palette.text.secondary,
  }));

const allLists = [
    {
      poemTypeName: "Haiku",
      poemTypeDesc: "A Japanese poem of 17 syllables in three lines of five, seven, and five"
    },

    {
        poemTypeName: "Quatrain",
        poemTypeDesc: "A stanza of 4 lines with alternate rhymes"
    },
    {
        poemTypeName: "Shakespearean Sonnet",
        poemTypeDesc: "A type of sonnet much used by Shakespeare, written in iambic pentameter and consisting of 3 quatrains and a final couplet with the rhyme scheme abab cdcd efef gg"
    },
    {
        poemTypeName: "Villanelle",
        poemTypeDesc: "A 19-line poem with 2 rhymes throughout, consisting of 5 tercets and a quatrain, with the first and third lines of the opening tercet recurring alternately at the end of the other tercets and with both repeated at the close of the concluding quatrain"
    },
]
export default function PoemTypeCardList() {
  return (
    <Box container>
      <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
      {allLists.map((item) => (
        <Grid item xs={6}>
        <Item>
            <PoemTypeCard 
                key={`PoemTypeCard${item.poemTypeName}`} 
                poemTypeName={item.poemTypeName} 
                poemTypeDesc={item.poemTypeDesc}
                cardSize={"medium"}/>
        </Item>
      </Grid>
      ))}
      </Grid>
    </Box>
  );
}