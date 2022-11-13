package model;

import java.util.ArrayList;

public class Opciones {

	
	ArrayList <User> listaUsuarios = new ArrayList();
	private int velocidad = 200;
	private boolean hayUsuarios = false;
	private User usuarioSeleccionado = null;
	
	
	
	public Opciones (){
		
	}

	public String crearUsuario (String nombre){
		String mensaje = "no se ha podido crear el perfil";
		if (nombre != null && verificarEsRepetido(nombre) != true){
			User usuario= new User (nombre);
			this.hayUsuarios = true;
			listaUsuarios.add(usuario);
			usuarioSeleccionado = usuario;
			mensaje = "se ha creado el perfil con éxito";
			
		}
		return mensaje;

	}
	private boolean verificarEsRepetido(String nombre) {
		boolean esRepetido =true;
		
		User userTemp = obtenerUsuario(nombre);
		if(userTemp == null){
			esRepetido = false;
		}
		return esRepetido;
	}

	public void actualizarUsuario (String nombreAntiguo, String nombreNuevo){

		User usuario = obtenerUsuario(nombreAntiguo);
		if (usuario != null){
			usuario.setName(nombreNuevo);
		}

	}
	
	public void eliminarUsuario (String nombre){

		User usuario= obtenerUsuario(nombre);
		verificarHayUsuarios();
		listaUsuarios.remove(usuario);

	}
	
	private void verificarHayUsuarios() {
		if (listaUsuarios.size()!= 0){
			hayUsuarios = true;
		}else{
			hayUsuarios = false;
		}
		
	}

	public User obtenerUsuario (String nombre) {
		User usuarioTemp = null;
		
		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (nombre.equals(listaUsuarios.get(i).getName())){
				usuarioTemp = listaUsuarios.get(i);
			}
		}
		
		return usuarioTemp;
		
	}
	
	public ArrayList<User> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<User> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public int getVelocidad() {
		return velocidad;
	}
// la velocidad es recibida como parametro de 3 formas , 1,2 o 3 -- donde los check del controller determinan todo
	public void setVelocidad(int velocidad) {
		
		int vel = 0;
		if (velocidad == 1){
			vel =175;
		}
		
		if (velocidad == 2){
			vel =150;
		}
		if (velocidad == 3){
			vel =125;
		}
		this.velocidad = vel;
	}

	public boolean getHayUsuarios() {
		return hayUsuarios;
	}

	public void setHayUsuarios(boolean hayUsuarios) {
		this.hayUsuarios = hayUsuarios;
	}

	public User getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(User usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}
	
	
	
	
	
	
}
