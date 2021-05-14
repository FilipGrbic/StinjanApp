package com.panonit.StinjanApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="permission")
@Getter
@Setter
public class Permission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "permissionId")
	int permissionId;
	
	@OneToOne
	@JoinColumn(name = "roleId")
	Role role;
	
	@Column(name="tableName")
	private String tableName;
	
	@Column(name="canCreate")
	private boolean canCreate;
	
	@Column(name="canRead")
	private boolean canRead;
	
	@Column(name="canDelete")
	private boolean canDelete;
	
	@Column(name="canUpdate")
	private boolean canUpdate;
	
	public Permission() {
	}

	public Permission(int permissionId, Role role, String tableName, boolean canCreate, boolean canRead,
			boolean canDelete, boolean canUpdate) {
		super();
		this.permissionId = permissionId;
		this.role = role;
		this.tableName = tableName;
		this.canCreate = canCreate;
		this.canRead = canRead;
		this.canDelete = canDelete;
		this.canUpdate = canUpdate;
	}
}
