import './App.css';

import { Container, Row, Col } from 'react-bootstrap';


import Home from './components/Home';
import Login from './components/Login';
import Welcome from './components/Admin/Welcome';
import WelcomeManager from './components/Manager/WelcomeManager';
import Rooms from './components/Admin/Rooms';
import RoomList from './components/Admin/RoomList';
import Employee from './components/Admin/Employee';
import AllEmployees from './components/Admin/AllEmployees';
import AllOrders from './components/Admin/AllOrders';
import WelcomeRecep from './components/Receptionist/WelcomeRecep';
import AvailableRooms from './components/Receptionist/AvailableRooms';
import Orders from './components/Receptionist/Orders';
import TotalOrders from './components/Manager/TotalOrders';
import Booking from './components/Receptionist/Booking';
import ActiveOrders from './components/Receptionist/ActiveOrders';
import CurrentBookings from './components/Manager/CurrentBookings';
import TotalRooms from './components/Receptionist/TotalRooms';
import AllRooms from './components/Manager/AllRooms';
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
          <Route path="/login" exact component={Login}/>
        <Route path="/" exact component={Home}/>
        < Route path = "/admin"
        exact component = { Welcome }/>
         <Route path = "/admin/add"
        exact component = { Rooms }/> 
          <Route path = "/admin/edit/:roomNo"
        exact component = { Rooms }/> 
        <Route path = "/admin/list"
        exact component = { RoomList }/> 

         <Route path = "/admin/post"
        exact component = { Employee}/>
     <Route path = "/admin/update/:registeredNo"
        exact component = { Employee}/>
      <Route path = "/admin/all"
        exact component = { AllEmployees }/>
        <Route path = "/admin/allorders"
        exact component = { AllOrders }/>



< Route path = "/manager"
        exact component = { WelcomeManager }/>
                   < Route path = "/manager/TotalOrders" 
        exact component = { TotalOrders} />
                           < Route path = "/manager/allrooms" 
        exact component = { AllRooms } />
         < Route path = "/manager/CurrentBookings" 
        exact component = { CurrentBookings } />

< Route path = "/receptionist"
        exact component = { WelcomeRecep }/>
        < Route path = "/receptionist/search" 
        exact component = { AvailableRooms} />
           < Route path = "/receptionist/Orders" 
        exact component = { Orders} />
         < Route path = "/receptionist/Booking" 
        exact component = {Booking} />
        < Route path = "/receptionist/activeorders" 
        exact component = {ActiveOrders} />
         < Route path = "/receptionist/totalrooms" 
        exact component = {TotalRooms} />

        
        </Switch>

        </Col>

        </Row>

        </Container> 
        </Router>
    );
}

export default App;