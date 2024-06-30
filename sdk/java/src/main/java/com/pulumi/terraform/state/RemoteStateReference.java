package com.pulumi.terraform.state;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.resources.CustomResource;
import com.pulumi.resources.CustomResourceOptions;

import java.util.Map;

/**
 * Manages a reference to a Terraform Remote State. The root outputs of the remote state are available
 * via the <see cref="Outputs"/> property or the <see cref="GetOutput"/> method.
 */
public class RemoteStateReference extends CustomResource {
    /**
     * The root outputs of the referenced Terraform state.
     */
    @Export(name = "outputs")
    public Output<Map<String, Object>> outputs;

    /**
     * Create a RemoteStateReference resource with the given unique name, arguments, and options.
     * <param name="name">The unique name of the remote state reference.</param>
     * <param name="args">The arguments to use to populate this resource's properties.</param>
     */
    public RemoteStateReference(String name, RemoteStateReferenceArgs args) {
        super("terraform:state:RemoteStateReference",
                name,
                args,
                CustomResourceOptions.builder().id(name).build());
    }

    /**
     * Create a RemoteStateReference resource with the given unique name, arguments, and options.
     * <param name="name">The unique name of the remote state reference.</param>
     * <param name="args">The arguments to use to populate this resource's properties.</param>
     * <param name="options">A bag of options that control this resource's behavior.</param>
     */
    public RemoteStateReference(String name, RemoteStateReferenceArgs args, CustomResourceOptions options) {
        super("terraform:state:RemoteStateReference",
                name,
                args,
                CustomResourceOptions.merge(options, CustomResourceOptions.builder().id(name).build()));
    }

    /**
     * Fetches the value of a root output from the Terraform Remote State.
     * <param name="name">The name of the output to fetch. The name is formatted exactly as per
     * the "output" block in the Terraform configuration.</param>
     * <returns></returns>
     */
    public Output<Object> getOutput(String name) {

        return getOutput(Output.of(name));
    }

    /**
     * Fetches the value of a root output from the Terraform Remote State.
     * <param name="name">The name of the output to fetch. The name is formatted exactly as per
     * the "output" block in the Terraform configuration.</param>
     * <returns></returns>
     */
    public Output<Object> getOutput(Output<String> name) {

        return Output.tuple(name, outputs).applyValue(both -> both.t2.get(both.t1));
    }

}
    