import './App.css';

import { Container, Row, Col } from 'react-bootstrap';


import Home from './components/Home';
import Welcome from './components/Admin/Welcome';
import Rooms from './components/Admin/Rooms';
import RoomList from './components/Admin/RoomList';
import AllEmployees from './components/Admin/AllEmployees';
import AllOrders from './components/Admin/AllOrders';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';

function App() {
    const marginTop = {
        marginTop: "20px"
    }
    return ( <Router>
        
        <Container>
        <Row>
        <Col lg = { 12 }
        style = { marginTop } >
        <Switch>
        <Route path="/" exact component={Home}/>
        < Route path = "/admin"
        exact component = { Welcome }/>
         <Route path = "/admin/add"
        exact component = { Rooms }/> 
        <Route path = "/admin/list"
        exact component = { RoomList }/> 
                <Route path = "/admin/all"
        exact component = { AllEmployees }/>
        <Route path = "/admin/allorders"
        exact component = { AllOrders }/>
        
        
        </Switch>

        </Col>

        </Row>

        </Container> 
        </Router>
    );
}

export default App;