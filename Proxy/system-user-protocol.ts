export type SystemUserAddressProtocol = { 
	street: string; 
	number: number 
};

// Interface de Usuário
export interface SystemUserProtocol {
	firstName: string;
	userName: string;

	getAddresses(): Promise<SystemUserAddressProtocol[]>;
}
