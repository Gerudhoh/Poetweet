// Packages
import * as React from 'react';

//Material UI Components
import Button from '@mui/material/Button';
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';

import { styled } from '@mui/material/styles';

//Styling

const PoemTypeCardStyles = styled(Box)(({ theme }) => ({
    position: 'absolute',
    top: 0,
    backgroundColor: '#533745',
    opacity: 0,
    color: '#D7C0AD',
    width: '100%',
    height: '100%',
    textAlign: 'center',
    '&:hover': {
      opacity: 0.6,
    }
  }));
  
  const poemTypeCardStyles = {
    small:
    {
      minSize: 100,
      buttonSize: "inherit",
      fontSize: 14,
      iconSize: { height: '15px', width: '15px' }
    },
    medium: {
      minSize: 120,
      buttonSize: "inherit",
      fontSize: 16,
      iconSize: { height: '25px', width: '25px' }
    },
    large: {
      minSize: 180,
      buttonSize: "inherit",
      fontSize: 20,
      iconSize: { height: '25px', width: '25px' }
    }
  };
  
  class PoemTypeCard extends React.Component {

    constructor(props) {
        super(props);
        this.size = poemTypeCardStyles[this.props.cardSize];
        this.poemTypeName = this.props.poemTypeName;
        this.poemTypeDesc = this.props.poemTypeDesc;
      }


    render() {
        return (
          <Card className="PoemTypeCard" >
            <CardContent>
            <Box>
                <Typography variant="h6"><b>{this.poemTypeName}</b></Typography>
                <Typography variant="p">{this.poemTypeDesc}</Typography>
            </Box>
            </CardContent>
            <CardContent
            className="gradient-cover"
            sx={{
              '&:hover, &:focus-within': {
                opacity: 1,
              },
              opacity: 0,
              transition: '0.1s ease-in',
              }}
        >
                <Button variant="outlined">Write Poem</Button>
            </CardContent>
          </Card>
        );
      }
  }
  export default PoemTypeCard;