import React from 'react';
import {Route, Routes} from "react-router-dom";

import HomePage from './HomePage';
import PoemGenerationPage from './PoemGenerationPage';

export default function RouteSwitch () {
    return (
      <div>
            <Routes>
                <Route exact path="/" element={<HomePage/>}/>
                <Route exact path="/poemGeneration" element={<PoemGenerationPage/>}/>
            </Routes>
      </div>
    );
}