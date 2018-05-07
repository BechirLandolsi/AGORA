package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_translation")
public class Translation implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private Long id;
		
		@Column(name = "anglais")
		private String anglais;
		
		@Column(name = "français")
		private String français;

		public Translation() {
			super();
		}

		public Translation(Long id, String anglais, String français) {
			super();
			this.id = id;
			this.anglais = anglais;
			this.français = français;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getAnglais() {
			return anglais;
		}

		public void setAnglais(String anglais) {
			this.anglais = anglais;
		}

		public String getFrançais() {
			return français;
		}

		public void setFrançais(String français) {
			this.français = français;
		}
		
		
		
		
		

}
