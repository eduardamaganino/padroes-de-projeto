import {
	SystemUserProtocol,
	SystemUserAddressProtocol,
} from "./system-user-protocol";
import { AdminUser } from "./admin-user";

export class SystemUserProxy implements SystemUserProtocol {
	// Usuário "real"
	private realUser: SystemUserProtocol | null = null;
	// Endereços dos usuários reais
	private realUserAddresses: SystemUserAddressProtocol[] | null = null;

	// Construtor do UsuárioProxy
	constructor(public firstName: string, public userName: string) {}

	// Método de associação do Objeto base ("Usuário real") com o Proxy
	private createUser(): SystemUserProtocol {
		if (this.realUser === null) {
			this.realUser = new AdminUser(this.firstName, this.userName);
		}

		return this.realUser;
	}

	async getAddresses(): Promise<SystemUserAddressProtocol[]> {
		this.realUser = this.createUser();
		// return this.realUser.getAddresses();

		/* Verifica o cache, se o endereço do usuário for NULL faz uma chamada assíncrona para buscar os endereços em um Banco de dados por exemplo. */
		if (this.realUserAddresses === null) {
			this.realUserAddresses = await this.realUser.getAddresses();
		}

		return this.realUserAddresses;
	}
}
