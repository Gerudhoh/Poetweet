// Packages
import * as React from 'react';

//Material UI Components
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';

//Styling

  const poemCardStyles = {
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

  class PoemCard extends React.Component {
    constructor(props) {
        super(props);
        this.size = poemCardStyles[this.props.cardSize];
        this.poem = this.props.poem;
      }

    render() {
        return (
          <Card className="PoemCard" >
            <CardContent>
            <Box>
                <Typography variant="h4">Poem</Typography>
                {this.poem.map((line) => (
                  <Typography variant="h6">{line.text}</Typography>
                ))}
            </Box>
            </CardContent>
          </Card>
        );
      }
  }
  export default PoemCard;