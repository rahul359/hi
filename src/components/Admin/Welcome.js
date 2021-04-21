import React from 'react';

import { Jumbotron,Container } from 'react-bootstrap';
import NavigationBar from './NavigationBar';
import Footer from './Footer';

class Welcome extends React.Component {
    render() {
        return ( 
            <Container>
        <NavigationBar />
        <Jumbotron className = "bg-dark text-white" >
            <h1 > Welcome Admin </h1> 
            <p>
            Have a Great day. 
            </p> 
            </Jumbotron>
            <Footer />
            </Container>
           

        );
    }

}

export default Welcome;