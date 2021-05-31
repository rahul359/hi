import React, { Component } from 'react';
import { Card,Form, Button, Col} from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSave,  faUndo } from '@fortawesome/free-solid-svg-icons';
import axios from 'axios';


export default class Login extends Component{

  constructor(props) {
      super(props);
    this.state = this.initialState;
    this.loginChange = this.loginChange.bind(this);
    this.submitLogin = this.submitLogin.bind(this);
}

initialState = {
   email: '',
    password: '',
    token:'',
    user: {
      designation: '',
      name: '',
      email: ''
  }
  
    
}
resetLogin = () => {
  this.setState(() => this.initialState);
}



submitLogin= event => {

  event.preventDefault();
 
  const login = {
    email: this.state.email,
    password:this.state.password

  };
      
  axios.post("http://localhost:9090/loginOrSignup/authenticate", login)
  .then(response => response.data)
  .then((data) => {
    localStorage.setItem("token",data.token);
    console.log(localStorage.getItem('token'));
    this.setState({ token: data.token });
    this.setState({ user: data.user});
     });
     if (this.state.token !== null)
     {
       if(this.state.user.designation == "OWNER")
       {
         
        this.props.history.push('/admin');
       }
       else if(this.state.user.designation == "MANAGER")
       {
         
        this.props.history.push('/manager');
       }
       else if(this.state.user.designation == "RECEPTIONIST")
       {
        this.props.history.push('/receptionist');
       }
     }
     else {
      this.props.history.push('/');
     }
}

loginChange = event => {
  this.setState({
      [event.target.name]: event.target.value
  });
}




render() 
        {

  return (
    
    <Card className = { " border  offset-sm-3 col-md-5 border-dark bg-dark  text-center text-white  " }>
            
            <Card.Header > <h4>Welcome to PALM HOTEL</h4> <br /><h5>Login </h5> </Card.Header >
            <Form onReset = { this.resetLogin }
            onSubmit = { this.submitLogin }
            id = "RoomFormId">
            <Card.Body>
            <Form.Group Col="col-sm-5"
            controlId = "formGridRoomNumber" >
            <Form.Label> Email </Form.Label> 
            <Form.Control required autoComplete = "off"
            name = "email"
            type="text"
            value = { this.state.email }
            onChange = { this.loginChange }
            className = { "bg-dark text-white" }
            placeholder = "Enter Email"/>
            </Form.Group>
            
             <Form.Group 
            controlId = "formGridType" >
            <Form.Label> Password </Form.Label> 
            <Form.Control required type = "password"
            autoComplete = "off"
            name = "password"
            value = { this.state.password }
            onChange = { this.loginChange }
            className = { "bg-dark text-white" }
            placeholder = "Enter Password" />
            </Form.Group> 

            </Card.Body>
            <Card.Footer style = {
                { "textAlign": "right" } } >
            <Button size = "sm"
            variant = "success"
            type = "submit" >
            <FontAwesomeIcon icon = {faSave}/> Submit</Button> { ' '} 
            <Button size = "sm" variant = "info" type = "reset" >
            <FontAwesomeIcon icon = { faUndo }/>Reset  </Button> 
            </Card.Footer> 
            </Form>
            </Card>
            

          );

    }
            
          

}